package ir.mhe47880.coffeeshopapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.theme.CreamyBrown
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont


@Preview(
    device = Devices.PIXEL_5,
    showSystemUi = true,
)
@Composable
fun WelcomeScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues()),
    ){

        //Images
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(R.drawable.coffeeimage),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                        .zIndex(1f)
                        .scale(scaleX = 1f, scaleY = 2f),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(R.drawable.black_shadow),
                    contentDescription = null
                )

            }


            //Texts & Button
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {

                //Texts
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Box(
                        modifier = Modifier.width(400.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = stringResource(R.string.fall_in_love),
                            minLines = 3,
                            style = TextStyle(
                                letterSpacing = TextUnit(value = 0.5f, type = TextUnitType.Sp),
                                fontSize = 40.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.SemiBold,
                                color = White
                            )
                        )
                    }

                    Box(
                        modifier = Modifier.width(400.dp),
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 30.dp, horizontal = 8.dp),
                            text = stringResource(R.string.welcome_text),
                            style = TextStyle(
                                letterSpacing = TextUnit(value = 1f, type = TextUnitType.Sp),
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.Normal,
                                color = White
                            )
                        )
                    }

                }

                //Bottom Button
                Box(
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        modifier = Modifier
                            .padding(horizontal = 26.dp, vertical = 30.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                        ,
                        colors = ButtonDefaults.buttonColors(containerColor = CreamyBrown),
                        shape = RoundedCornerShape(18.dp),
                        onClick = {
                        }
                    )
                    {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Get Started",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = soraFont,
                            fontWeight = FontWeight.SemiBold,
                            color = White
                        )
                    }
                }

            }

        }
    }
}