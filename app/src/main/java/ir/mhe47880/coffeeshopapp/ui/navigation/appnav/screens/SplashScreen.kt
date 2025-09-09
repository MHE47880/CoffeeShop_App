package ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.navigation.appnav.screens.utlis.screenSelector
import ir.mhe47880.coffeeshopapp.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {

        LaunchedEffect(true) {

            delay(2000)

            navController.navigate(screenSelector(context)) {
                popUpTo(Screens.SplashScreen) { inclusive = true }
            }

        }

        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.loading_dots)
        )

        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true
        )

        Image(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center),
            painter = painterResource(id = R.mipmap.ic_coffee),
            contentDescription = null
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            LottieAnimation(
                modifier = Modifier.size(150.dp),
                composition = composition,
                progress = { progress },
                contentScale = ContentScale.Crop
            )
        }

    }

}