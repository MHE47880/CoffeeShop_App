package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.HomeScreenState
import ir.mhe47880.coffeeshopapp.repository.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: HomeScreenRepository
) : ViewModel() {

    companion object { val TOP_APP_BAR_HEIGHT = 270.dp }

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState

    init {
        fetchCoffeeData()
    }

    private fun fetchCoffeeData() {
        viewModelScope.launch(Dispatchers.IO) {
            val coffeeList = repository.getCoffeeList()
            updateState {
                copy(
                    coffeeList = coffeeList,
                    isEmpty = coffeeList.isEmpty(),
                    columnCount = if (coffeeList.isNotEmpty()) 2 else 1
                )
            }
        }
    }

    fun dynamicTopAppBarHeight(state: LazyGridState) {
        updateState {
            copy(topAppBarHeight = if (state.firstVisibleItemIndex > 2) 0.dp else 270.dp)
        }
    }

    fun updateTextFieldValue(newValue: String) {
        updateState { copy(searchText = newValue) }
        filterItems(newValue)
    }

    private fun filterItems(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val filtered = repository.getCoffeeList().filter {
                it.name.trim().lowercase().contains(query.trim().lowercase())
            }
            updateState {
                copy(
                    coffeeList = filtered,
                    isEmpty = filtered.isEmpty(),
                    columnCount = if (filtered.isNotEmpty()) 2 else 1
                )
            }
        }
    }

    private fun updateState(reducer: HomeScreenState.() -> HomeScreenState) {
        _uiState.value = _uiState.value.reducer()
    }
}