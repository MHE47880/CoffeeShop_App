package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.ui.unit.dp

fun dynamicTopAppBarHeight(state: LazyGridState) {
    if (state.firstVisibleItemIndex > 2)
        DpValues.TOP_APP_BAR_HEIGHT = 0.dp
    else
        DpValues.TOP_APP_BAR_HEIGHT = 270.dp
}