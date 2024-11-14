package com.example.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cats_api.CatsApi
import com.example.cats_api.models.Order
import com.example.data.model.Cat
import kotlinx.coroutines.flow.Flow

class CatsRepository(
    private val api: CatsApi,
) {
    fun getPaginatedCats(orderParam: String, limit: Int): Flow<PagingData<Cat>> {
        return Pager(
            config = PagingConfig(
                pageSize = limit,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { CatsPagingSource(this, limit = limit, orderParam = orderParam) }
        ).flow
    }

     suspend fun search(orderParam: String, limit: Int, page: Int): Result<List<Cat>> {
        return try {
            val cats = api.search(order = Order.valueOf(orderParam), limit = limit, page = page).map {
                it.toCats()
            }
            Result.success(cats)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}