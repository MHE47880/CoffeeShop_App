package ir.mhe47880.coffeeshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import ir.mhe47880.coffeeshopapp.ui.screens.SetupNavigation
import ir.mhe47880.coffeeshopapp.ui.theme.CoffeeShopAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            CoffeeShopAppTheme {
                SetupNavigation()
            }
        }
    }
}