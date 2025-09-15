package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import androidx.annotation.DrawableRes
import ir.mhe47880.coffeeshopapp.R
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomNavScreens(
    @param:DrawableRes val icon: Int
) {
    @Serializable
    object HomeScreen : BottomNavScreens(icon = R.drawable.ic_home)
    @Serializable
    object ShoppingCartScreen : BottomNavScreens(icon = R.drawable.ic_shopping_bag)

    companion object {
        val screens = listOf(
            HomeScreen,
            ShoppingCartScreen
        )
    }
}