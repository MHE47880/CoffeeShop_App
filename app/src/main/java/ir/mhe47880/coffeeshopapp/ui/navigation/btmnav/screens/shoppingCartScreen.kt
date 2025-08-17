package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import androidx.compose.foundation.LocalOverscrollFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.LazyShoppingCartProductList
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.NoProductFound
import ir.mhe47880.coffeeshopapp.ui.theme.BlackDarkest
import ir.mhe47880.coffeeshopapp.ui.theme.CreamyBrown
import ir.mhe47880.coffeeshopapp.ui.theme.LightCream
import ir.mhe47880.coffeeshopapp.ui.theme.LightestGray
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont
import ir.mhe47880.coffeeshopapp.viewmodel.PublicProductListViewModel
import java.util.Locale

@Composable
fun ShoppingCartScreen(viewModel: PublicProductListViewModel = hiltViewModel()) {

    if (viewModel.getShoppingCartProductList().size > 0) {
        val totalPrice by viewModel.totalPrice.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(8.dp)
                    .height(40.dp)
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    IconButton({}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back_arrow),
                            contentDescription = null
                        )
                    }
                }

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.order),
                        style = TextStyle(
                            color = BlackDarkest,
                            fontSize = 16.sp,
                            fontFamily = soraFont,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

            }

            Column {
                CompositionLocalProvider(
                    LocalOverscrollFactory provides null
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                    ) {

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            text = stringResource(R.string.delivery_address),
                            style = TextStyle(
                                color = BlackDarkest,
                                fontSize = 18.sp,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            text = stringResource(R.string.address_title),
                            style = TextStyle(
                                color = BlackDarkest,
                                fontSize = 16.sp,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.SemiBold
                            )
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            text = stringResource(R.string.address_description),
                            style = TextStyle(
                                color = BlackDarkest,
                                fontSize = 14.sp,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.Normal
                            )
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        HorizontalDivider(
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .clip(CircleShape),
                            color = LightestGray,
                            thickness = 2.dp
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        LazyShoppingCartProductList()

                    }
                }

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 4.dp,
                    color = LightCream
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        text = stringResource(R.string.payment_summary),
                        style = TextStyle(
                            color = BlackDarkest,
                            fontFamily = soraFont,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.total_price),
                                style = TextStyle(
                                    color = BlackDarkest,
                                    fontFamily = soraFont,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            )

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "$ " + String.format(
                                    locale = Locale.US,
                                    format = "%.2f",
                                    totalPrice
                                ),
                                style = TextStyle(
                                    color = BlackDarkest,
                                    fontFamily = soraFont,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End
                                )
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.delivery_fee),
                                style = TextStyle(
                                    color = BlackDarkest,
                                    fontFamily = soraFont,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            )

                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "$ 1.00",
                                style = TextStyle(
                                    color = BlackDarkest,
                                    fontFamily = soraFont,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(CreamyBrown),
                        shape = RoundedCornerShape(18.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = stringResource(R.string.order),
                            style = TextStyle(
                                color = White,
                                fontFamily = soraFont,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }
            }
        }
    } else
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            NoProductFound()
        }
}

