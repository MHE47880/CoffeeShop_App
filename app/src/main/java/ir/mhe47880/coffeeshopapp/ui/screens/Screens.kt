package ir.mhe47880.coffeeshopapp.ui.screens

sealed class Screens(val route: String){

    data object WelcomeScreen: Screens("welcome_screen")

}