package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.BottomNavScreens
import ir.mhe47880.coffeeshopapp.ui.theme.BlackDarkest
import ir.mhe47880.coffeeshopapp.ui.theme.CreamyBrown
import ir.mhe47880.coffeeshopapp.ui.theme.White

@SuppressLint("RestrictedApi")
@Composable
fun CustomBottomNav(
    navController: NavHostController,
) {

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WindowInsets.navigationBars.asPaddingValues())
            .height(65.dp)
            .background(White),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavScreens.screens.forEach { screen ->

            val isSelected = currentBackStackEntry?.destination?.hasRoute(screen::class) ?: false

            Box(
                modifier = Modifier.size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        if (!isSelected) {
                            navController.navigate(screen) {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = false
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                ) {
                    Icon(
                        painter = painterResource(screen.icon),
                        contentDescription = screen::class.simpleName,
                        tint = if (isSelected) CreamyBrown else BlackDarkest
                    )
                }

                if (isSelected) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Surface(
                            modifier = Modifier
                                .width(12.dp)
                                .height(7.dp),
                            shape = CircleShape,
                            color = CreamyBrown
                        ) {}
                    }
                }
            }
        }
    }
}