package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.BottomNavScreens
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.HomeScreen
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.ShoppingCartScreen

@Composable
fun SetupBottomNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomNav(navController = navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = BottomNavScreens.HomeScreen,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable<BottomNavScreens.HomeScreen> { HomeScreen() }

            composable<BottomNavScreens.ShoppingCartScreen> {
                ShoppingCartScreen(navController = navController)
            }

        }

    }
}