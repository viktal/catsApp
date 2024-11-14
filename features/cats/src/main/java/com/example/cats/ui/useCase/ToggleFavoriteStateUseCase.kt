package com.example.cats.ui.useCase

import com.example.cats.ui.model.CatUI
import com.example.cats.ui.utils.toCat
import com.example.data.database.DatabaseRepository

class ToggleFavoriteStateUseCase(
    private val repository: DatabaseRepository
) {
    suspend operator fun invoke(cat: CatUI, isFavorite: Boolean) {
        if (isFavorite) {
            repository.saveFavorite(cat.toCat())
        } else {
            repository.deleteFavorite(cat.toCat())
        }
    }
}