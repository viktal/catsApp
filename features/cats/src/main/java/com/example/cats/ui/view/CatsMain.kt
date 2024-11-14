package com.example.cats.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.cats.R
import com.example.cats.ui.model.ContentTab
import com.example.cats.ui.utils.CatsNavHost
import com.example.cats.ui.viewModel.CatsMainViewModel

@Composable
fun CatsMainScreen() {
    val navController = rememberNavController()
    CatsNavHost(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CatsMainScreen(viewModel: CatsMainViewModel, navController: NavController) {

    val selectedTab by viewModel.selectedTab.collectAsState()
    val catsPagingItems = viewModel.catsPagingData.collectAsLazyPagingItems()

    val tabs = listOf(ContentTab.Latest, ContentTab.Newest, ContentTab.Random, ContentTab.Favorite)

    Column {
        TopAppBar(
            title = { Text(stringResource(id = R.string.app_name), fontSize = 20.sp) },
        )
        TabRow(
            selectedTabIndex = selectedTab.ordinal,
            modifier = Modifier.fillMaxWidth(),
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab.ordinal == index,
                    onClick = {
                        if (selectedTab.ordinal != index) {
                            viewModel.updateSelectTab(tab)
                        }
                    },
                    text = { Text(tab.name) }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        CatListContent(catsPagingItems, navController, viewModel)
    }
}

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.errorContainer)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(id = R.string.error_message), color = MaterialTheme.colorScheme.onError)
        }
    }
}

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
) {
    Column {
        Box(
            modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
