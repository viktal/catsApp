package com.example.cats.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.model.ContentTab
import com.example.cats.ui.useCase.GetCatsFromServerUseCase
import com.example.cats.ui.useCase.ToggleFavoriteStateUseCase
import com.example.data.database.DatabaseRepository
import com.example.data.database.ServerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CatsMainViewModel(
    private val getAllUseCase: GetCatsFromServerUseCase,
    private val toggleFavoriteStateUseCase: ToggleFavoriteStateUseCase,
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(ContentTab.Latest)
    val selectedTab: StateFlow<ContentTab> = _selectedTab.asStateFlow()

    private val _catsPagingData = MutableStateFlow<PagingData<CatUI>>(PagingData.empty())
    val catsPagingData: StateFlow<PagingData<CatUI>> = _catsPagingData

    private val _selectedCat = MutableStateFlow<CatUI?>(null)
    val selectedCat: StateFlow<CatUI?> = _selectedCat.asStateFlow()

    init {
        observeTabSelection()
    }

    fun updateSelectTab(tab: ContentTab) {
        _selectedTab.value = tab
    }

    fun updateSelectedCat(cat: CatUI) {
        _selectedCat.value = cat
    }

    fun favoriteStateChanged(cat: CatUI, isFavorite: Boolean?) {
        viewModelScope.launch {
            toggleFavoriteStateUseCase.invoke(cat, isFavorite ?: true)
        }
    }

    private fun observeTabSelection() {
        viewModelScope.launch {
            _selectedTab.collectLatest { tab ->

                val pagingDataFlow = getAllUseCase.invoke(tab.orderParam)
                    .cachedIn(viewModelScope)

                pagingDataFlow.collect { pagingData ->
                    _catsPagingData.value = pagingData
                }
            }
        }
    }
}
