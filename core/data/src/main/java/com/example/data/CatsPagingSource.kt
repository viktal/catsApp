package com.example.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.model.Cat

class CatsPagingSource(
    private val repository: CatsRepository,
    private val limit: Int,
    private val orderParam: String
) : PagingSource<Int, Cat>() {
    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {
        val page = params.key ?: 0

        return try {
            val cats = repository.search(orderParam, limit, page)
            LoadResult.Page(
                data = cats.getOrThrow(),
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (cats.isFailure) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}