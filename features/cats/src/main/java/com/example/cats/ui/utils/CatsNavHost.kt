package com.example.cats.ui.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cats.ui.model.Screen
import com.example.cats.ui.view.CatDetailScreen
import com.example.cats.ui.view.CatsMainScreen
import com.example.cats.ui.viewModel.CatsMainViewModel

@Composable
internal fun CatsNavHost(navController: NavHostController, viewModel: CatsMainViewModel) {

    NavHost(navController = navController, startDestination = Screen.CatsListScreen.route) {
        composable(route = Screen.CatsListScreen.route) {
            CatsMainScreen(viewModel = viewModel, navController = navController)
        }
        composable(route = Screen.CatDetailScreen.route) {
            CatDetailScreen(viewModel = viewModel, navController = navController)
        }
    }
}
