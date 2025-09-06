package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.CustomTopAppBar
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.DoubleBackToExit
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.LazyProductList
import ir.mhe47880.coffeeshopapp.ui.theme.White

@Composable
fun HomeScreen() {

    val lazyGridState = rememberLazyGridState()

    val focusManager = LocalFocusManager.current

    DoubleBackToExit()

    Column {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    focusManager.clearFocus()
                }
                .background(White)
        ){
            CustomTopAppBar(lazyGridState = lazyGridState)
            LazyProductList(lazyGridState = lazyGridState)
        }
    }
}