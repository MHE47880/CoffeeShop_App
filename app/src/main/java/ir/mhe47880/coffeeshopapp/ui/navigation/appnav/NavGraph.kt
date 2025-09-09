package ir.mhe47880.coffeeshopapp.ui.navigation.appnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.MainScreen
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.Screens
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.SplashScreen
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.WelcomeScreen

@Composable
fun SetupNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen
    ) {

        composable<Screens.SplashScreen> { SplashScreen(navController) }

        composable<Screens.WelcomeScreen> { WelcomeScreen(navController) }

        composable<Screens.MainScreen> { MainScreen() }

    }


}