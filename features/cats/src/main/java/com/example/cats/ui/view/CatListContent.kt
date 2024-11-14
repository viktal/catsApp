package com.example.cats.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.cats.ui.viewModel.CatsMainViewModel
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.model.Screen

@Composable
fun CatListContent(
    cats: LazyPagingItems<CatUI>,
    navController: NavController,
    viewModel: CatsMainViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            cats.loadState.prepend is LoadState.Loading || cats.loadState.refresh is LoadState.Loading -> {
                item { ProgressIndicator(modifier = Modifier) }
            }

            cats.loadState.prepend is LoadState.Error || cats.loadState.refresh is LoadState.Error -> {
                item {
                    ErrorMessage(modifier = Modifier.clickable {
                        cats.refresh()
                    })
                }
            }

            else -> {
                items(cats.itemCount) { index ->
                    cats[index]?.let { cat ->
                        CatItem(cat = cat, onClick = {
                            viewModel.updateSelectedCat(cat)
                            navController.navigate(Screen.CatDetailScreen.route)
                        })
                    }
                }

                cats.apply {
                    when (loadState.append) {
                        is LoadState.Loading -> {
                            item { ProgressIndicator(modifier = Modifier) }
                        }

                        is LoadState.Error -> {
                            item {
                                ErrorMessage(modifier = Modifier.clickable {
                                    cats.refresh()
                                })
                            }
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}