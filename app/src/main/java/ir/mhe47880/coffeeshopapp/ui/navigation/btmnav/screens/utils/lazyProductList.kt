package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.viewmodel.HomeScreenViewModel

@Composable
fun LazyProductList(
    lazyGridState: LazyGridState,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    val padding by animateDpAsState(
        targetValue =
            if (lazyGridState.isScrolled) 0.dp else state.topAppBarHeight,
        animationSpec = tween(durationMillis = 400)
    )

    LazyVerticalGrid(
        modifier = Modifier
            .padding(top = padding)
            .background(White),
        state = lazyGridState,
        columns = GridCells.Fixed(state.columnCount),
        userScrollEnabled = state.coffeeList.size > 2,
        overscrollEffect = null
    ) {

        if (!state.isEmpty) {
            items(count = 2) { Spacer(Modifier.height(25.dp)) }

            items(
                count = state.coffeeList.size,
                key = { index -> FakeCoffeeData.coffeeDataList[index].id }
            ) {
                ProductCard(
                    productList = state.coffeeList,
                    index = it
                )
            }

            if (state.coffeeList.size < 5)
                items(count = 2) { Spacer(modifier = Modifier.height(150.dp)) }

        } else item { NoProductFound() }
    }

}