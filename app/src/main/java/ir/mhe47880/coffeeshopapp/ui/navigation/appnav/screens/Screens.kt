package ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens

import kotlinx.serialization.Serializable
@Serializable
sealed class Screens() {
    @Serializable
    data object WelcomeScreen : Screens()
    @Serializable
    data object MainScreen : Screens()
    @Serializable
    data object SplashScreen : Screens()

}