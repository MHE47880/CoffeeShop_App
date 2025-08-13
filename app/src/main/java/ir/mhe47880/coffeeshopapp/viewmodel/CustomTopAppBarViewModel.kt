package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CustomTopAppBarViewModel @Inject constructor() : ViewModel() {

    companion object {
        var TOP_APP_BAR_HEIGHT = 270.dp

        private val _textFieldValue by mutableStateOf("")
        val textFieldValue
            get() = _textFieldValue
    }

    private val _topAppBarHeight = MutableStateFlow(TOP_APP_BAR_HEIGHT)
    val topAppBarHeight : StateFlow<Dp> = _topAppBarHeight

    fun dynamicTopAppBarHeight(state: LazyGridState) {
        TOP_APP_BAR_HEIGHT = if (state.firstVisibleItemIndex > 2)
            0.dp
        else
            270.dp
    }

}