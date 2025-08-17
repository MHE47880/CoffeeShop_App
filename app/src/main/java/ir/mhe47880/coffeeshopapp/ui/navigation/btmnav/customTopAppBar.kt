package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.isScrolled
import ir.mhe47880.coffeeshopapp.ui.theme.Black_Dark
import ir.mhe47880.coffeeshopapp.ui.theme.Black_Gray
import ir.mhe47880.coffeeshopapp.ui.theme.Dark_Gray
import ir.mhe47880.coffeeshopapp.ui.theme.LightGray
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont
import ir.mhe47880.coffeeshopapp.viewmodel.HomeScreenViewModel
import ir.mhe47880.coffeeshopapp.viewmodel.HomeScreenViewModel.Companion.TOP_APP_BAR_HEIGHT

@Composable
fun CustomTopAppBar(
    lazyGridState: LazyGridState,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val topAppBarHeight by viewModel.topAppBarHeight.collectAsState()

    val textFieldState by viewModel.textFieldValue.collectAsState()

    var isFocused by remember { mutableStateOf(false) }

    viewModel.dynamicTopAppBarHeight(state = lazyGridState)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .animateContentSize(animationSpec = tween(durationMillis = 400))
            .height(height = if (lazyGridState.isScrolled) topAppBarHeight else TOP_APP_BAR_HEIGHT)
    ) {

        //Background Gradiant
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(maxHeight = 250.dp)
                .height(200.dp)
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Black_Gray,
                            Black_Dark
                        ),
                        start = Offset(0f, 1000f),
                        end = Offset(1000f, 0f)
                    )
                )
        ) {}

        //SearchBox & SettingsIcon
        Column(
            modifier = Modifier.height(TOP_APP_BAR_HEIGHT),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 25.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Black_Dark,
                                    Dark_Gray,
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    TextField(
                        modifier = Modifier
                            .width(275.dp)
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused
                            },
                        value = textFieldState,
                        onValueChange = {
                            if (it.length <= 17) {
                                viewModel.updateTextFieldValue(it)
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        prefix = {
                            Icon(
                                modifier = Modifier.padding(end = 8.dp),
                                painter = painterResource(R.drawable.ic_search),
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Search Coffee",
                                style = TextStyle(
                                    color = LightGray,
                                    fontFamily = soraFont,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp
                                )
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = White,
                            unfocusedTextColor = White,
                            cursorColor = if (isFocused) White else Color.Transparent
                        )
                    )
                }

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }

            //Bottom Banner
            Box {
                Image(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    painter = painterResource(R.drawable.banner),
                    contentDescription = null
                )
            }
        }
    }

}