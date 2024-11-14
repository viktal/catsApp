package com.example.cats.ui.useCase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.utils.toCatUI
import com.example.data.CatsPagingSource
import com.example.data.database.DatabaseRepository
import com.example.data.database.ServerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCatsFromServerUseCase(
    private val serverRepository: ServerRepository,
    private val dbRepository: DatabaseRepository,
) {
    private val favoriteCatIds = mutableSetOf<String>()

    suspend operator fun invoke(orderParam: String): Flow<PagingData<CatUI>> {
        if (favoriteCatIds.isEmpty()) {
            favoriteCatIds.addAll(dbRepository.getFavoriteCatsIds())
        }

        val pager = Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = true),
            pagingSourceFactory = {
                CatsPagingSource(serverRepository, limit = 10, orderParam = orderParam)
            }
        ).flow

        return pager.map { cats ->
            cats.map {
                val cat = it.toCatUI()
                cat.copy(isFavorite = favoriteCatIds.contains(cat.id))
            }
        }
    }
}