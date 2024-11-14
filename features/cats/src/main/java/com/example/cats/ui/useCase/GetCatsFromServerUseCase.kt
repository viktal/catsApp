package com.example.cats.ui.useCase

import androidx.paging.PagingData
import androidx.paging.map
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.utils.toCatUI
import com.example.data.CatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCatsFromServerUseCase(
    private val repository: CatsRepository
) {
    operator fun invoke(orderParam: String): Flow<PagingData<CatUI>> {
        return repository.getPaginatedCats(orderParam, limit = 10).map { cats ->
            cats.map { it.toCatUI() }
        }
    }
}