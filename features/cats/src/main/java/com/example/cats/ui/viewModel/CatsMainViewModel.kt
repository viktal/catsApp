package com.example.cats.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cats.ui.model.CatUI
import com.example.cats.ui.model.ContentTab
import com.example.cats.ui.useCase.GetCatsFromServerUseCase
import com.example.cats_api.ApiServiceFactory
import com.example.data.CatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CatsMainViewModel(
    private val getAllUseCase: GetCatsFromServerUseCase,
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

    private fun observeTabSelection() {
        viewModelScope.launch {
            _selectedTab.collectLatest { tab ->

                val pagingDataFlow = when (tab) {
                    ContentTab.Favorite ->
                        getAllUseCase.invoke(ContentTab.Latest.orderParam)

                    else ->
                        getAllUseCase.invoke(tab.orderParam)
                }.cachedIn(viewModelScope)

                pagingDataFlow.collect { pagingData ->
                    _catsPagingData.value = pagingData
                }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = CatsRepository(ApiServiceFactory.CatsApi())
                CatsMainViewModel(
                    getAllUseCase = GetCatsFromServerUseCase(repository),
                )
            }
        }
    }
}
