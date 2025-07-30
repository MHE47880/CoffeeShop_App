package ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens

sealed class Screens(val route: String) {

    data object WelcomeScreen : Screens("welcome_screen")
    data object MainScreen : Screens("main_screen")

}