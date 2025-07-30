package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.BottomNavScreens
import ir.mhe47880.coffeeshopapp.ui.theme.CreamyBrown
import ir.mhe47880.coffeeshopapp.ui.theme.White

@Composable
fun CustomBottomNav(
    navController: NavHostController,
    currentScreen: NavBackStackEntry?
) {
    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .height(75.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavScreens.screens.forEach { screen ->
                Box(
                    modifier = Modifier.size(50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(screen.route)
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(screen.icon),
                            contentDescription = screen.route
                        )
                    }

                    if (screen.route == currentScreen?.destination?.route)
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Surface(
                                modifier = Modifier
                                    .width(12.dp)
                                    .height(7.dp),
                                shape = RoundedCornerShape(15.dp),
                                color = CreamyBrown
                            ) {}
                        }
                }
            }
        }
    }
}