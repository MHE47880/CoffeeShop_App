package ir.mhe47880.coffeeshopapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SetupNavigation(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.route
    ) {

        composable(
            route = Screens.WelcomeScreen.route
        ) { WelcomeScreen() }


    }


}