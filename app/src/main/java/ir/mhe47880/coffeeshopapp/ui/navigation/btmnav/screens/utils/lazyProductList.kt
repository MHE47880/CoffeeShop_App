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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import ir.mhe47880.coffeeshopapp.ui.theme.White

@Composable
fun LazyProductList(lazyGridState: LazyGridState) {

    val padding by animateDpAsState(
        targetValue = if (lazyGridState.isScrolled) 0.dp else DpValues.TOP_APP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 400)
    )

    LazyVerticalGrid(
        modifier = Modifier
            .padding(top = padding)
            .background(White),
        state = lazyGridState,
        columns = GridCells.Fixed(2),
        overscrollEffect = null
    ) {

        items(count = 2){ Spacer(Modifier.height(25.dp)) }

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