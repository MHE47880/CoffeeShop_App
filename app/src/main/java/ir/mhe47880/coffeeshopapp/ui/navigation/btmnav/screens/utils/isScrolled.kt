package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.foundation.lazy.grid.LazyGridState

val LazyGridState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 && firstVisibleItemScrollOffset > 0