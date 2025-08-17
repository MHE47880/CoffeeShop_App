package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    companion object {
        var TOP_APP_BAR_HEIGHT = 270.dp
    }

    private val _topAppBarHeight = MutableStateFlow(TOP_APP_BAR_HEIGHT)
    val topAppBarHeight: StateFlow<Dp> = _topAppBarHeight

    private var _textFieldState = MutableStateFlow("")
    val textFieldValue: StateFlow<String> = _textFieldState

    val getFilteredItems =
        FakeCoffeeData.coffeeDataList.filter {
            it.name.trim().lowercase().contains(textFieldValue.value.trim().lowercase())
        }

    private var _filteredItemsState = MutableStateFlow(getFilteredItems)
    val filteredItemsState: StateFlow<List<CoffeeInfo>> = _filteredItemsState

    val checkItems = getFilteredItems.isNotEmpty()

    private val _columnCount = if (checkItems) 2 else 1
    val columnCount: Int = _columnCount

    fun dynamicTopAppBarHeight(state: LazyGridState) {
        TOP_APP_BAR_HEIGHT = if (state.firstVisibleItemIndex > 2)
            0.dp
        else
            270.dp
    }

    fun updateTextFieldValue(newValue: String) {
        _textFieldState.value = newValue
        updateFilteredItems()
    }

    private fun updateFilteredItems() {
        _filteredItemsState.value =
            FakeCoffeeData.coffeeDataList.filter {
                it.name.trim().lowercase().contains(textFieldValue.value.trim().lowercase())
            }
    }

}