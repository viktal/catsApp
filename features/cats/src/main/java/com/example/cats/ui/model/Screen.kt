package com.example.cats.ui.model

sealed class Screen(val route: String) {
    data object CatsListScreen : Screen("catsList")
    data object CatDetailScreen : Screen("catDetail")
}