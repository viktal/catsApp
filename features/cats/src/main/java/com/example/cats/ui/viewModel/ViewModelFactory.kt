package com.example.cats.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cats.ui.useCase.GetCatsFromServerUseCase
import com.example.cats.ui.useCase.ToggleFavoriteStateUseCase
import com.example.data.database.DatabaseRepository
import com.example.data.database.ServerRepository

class ViewModelFactory(
    private val serverRepository: ServerRepository,
    private val dbRepository: DatabaseRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatsMainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CatsMainViewModel(
                GetCatsFromServerUseCase(serverRepository, dbRepository),
                ToggleFavoriteStateUseCase(dbRepository),
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}