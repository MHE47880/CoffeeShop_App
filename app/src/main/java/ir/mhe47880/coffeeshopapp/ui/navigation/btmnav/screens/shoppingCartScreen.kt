package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens

import androidx.compose.foundation.LocalOverscrollFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils.LazyShoppingCartProductList
import ir.mhe47880.coffeeshopapp.ui.theme.Black_Darkest
import ir.mhe47880.coffeeshopapp.ui.theme.LightestGray
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont

@Composable
fun ShoppingCartScreen() {

    Column {
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
                        color = Black_Darkest,
                        fontSize = 16.sp,
                        fontFamily = soraFont,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

        }

        CompositionLocalProvider(
            LocalOverscrollFactory provides null
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    text = stringResource(R.string.delivery_address),
                    style = TextStyle(
                        color = Black_Darkest,
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
                        color = Black_Darkest,
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
                        color = Black_Darkest,
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
    }
}

