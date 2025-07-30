package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import androidx.annotation.DrawableRes
import ir.mhe47880.coffeeshopapp.R

sealed class BottomNavScreens(
    val route: String,
    @param:DrawableRes val icon: Int
){

    data object HomeScreen : BottomNavScreens("home_screen", R.drawable.ic_home)
    data object ShoppingCartScreen : BottomNavScreens("shopping_cart", R.drawable.ic_shopping_bag)

    companion object {
        val screens = listOf(
            HomeScreen,
            ShoppingCartScreen
        )
    }
}