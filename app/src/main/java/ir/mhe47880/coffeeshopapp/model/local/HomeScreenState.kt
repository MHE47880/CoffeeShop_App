package ir.mhe47880.coffeeshopapp.model.local

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class
HomeScreenState(
    val topAppBarHeight: Dp = 270.dp,
    val searchText: String = "",
    val coffeeList: List<CoffeeInfo> = emptyList(),
    val isEmpty: Boolean = false,
    val columnCount: Int = 2
)
