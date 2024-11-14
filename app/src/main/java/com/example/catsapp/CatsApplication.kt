package com.example.catsapp

import android.app.Application
import com.example.cats.ui.viewModel.CatsMainViewModel
import com.example.cats.ui.viewModel.ViewModelFactory
import com.example.cats_api.ApiServiceFactory
import com.example.data.database.DatabaseRepository
import com.example.data.database.ServerRepository
import com.example.database.CatsDatabase

class CatsApplication : Application() {

    private val database by lazy { CatsDatabase(applicationContext) }
    private val api by lazy { ApiServiceFactory.CatsApi() }

    private val serverRepository by lazy { ServerRepository(api) }
    private val dbRepository by lazy { DatabaseRepository(database) }

    val catsViewModelFactory by lazy { ViewModelFactory(serverRepository, dbRepository) }
}