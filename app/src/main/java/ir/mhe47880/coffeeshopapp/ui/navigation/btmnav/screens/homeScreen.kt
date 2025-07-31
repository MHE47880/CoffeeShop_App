package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import DoubleBackToExit
import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.CustomTopAppBar
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.ProductCard
import ir.mhe47880.coffeeshopapp.ui.theme.White

@Composable
fun HomeScreen() {

    DoubleBackToExit()

    Scaffold(
        topBar = { CustomTopAppBar() }
    ) { paddingValues ->

        LazyVerticalGrid(
            modifier = Modifier
                .background(White)
                .padding(top = paddingValues.calculateTopPadding()),
            columns = GridCells.Fixed(2),
            overscrollEffect = null
        ) {

            items(
                count = FakeCoffeeData.coffeeDataList.size,
                key = { index -> FakeCoffeeData.coffeeDataList[index].id }
            ) {
                ProductCard(
                    productList = FakeCoffeeData.coffeeDataList,
                    index = it
                )
            }

        }

    }
}