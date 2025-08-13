package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.DoubleBackToExit
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.CustomTopAppBar
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.LazyProductList
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.viewmodel.CustomTopAppBarViewModel
import ir.mhe47880.coffeeshopapp.viewmodel.LazyProductListViewModel

@Composable
fun HomeScreen() {

    val lazyGridState = rememberLazyGridState()

    DoubleBackToExit()

    Column {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ){
            CustomTopAppBar(lazyGridState = lazyGridState)
            LazyProductList(lazyGridState = lazyGridState)
        }
    }
}