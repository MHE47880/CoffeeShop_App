package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import DoubleBackToExit
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.CustomTopAppBar
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.LazyProductList
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.ProductCard
import ir.mhe47880.coffeeshopapp.ui.theme.White

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