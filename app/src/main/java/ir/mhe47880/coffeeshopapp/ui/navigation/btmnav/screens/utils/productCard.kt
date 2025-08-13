package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.ui.theme.Black_Darkest
import ir.mhe47880.coffeeshopapp.ui.theme.LightGray
import ir.mhe47880.coffeeshopapp.ui.theme.White
import ir.mhe47880.coffeeshopapp.ui.theme.Yellow
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont
import ir.mhe47880.coffeeshopapp.viewmodel.PublicProductListViewModel

@Composable
fun ProductCard(
    productList: List<CoffeeInfo>,
    index: Int,
    viewModel: PublicProductListViewModel = hiltViewModel()
) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(180.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //Product Image & Rate
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(productList[index].imageAddress),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(15.dp),
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = null,
                            tint = Yellow
                        )

                        Text(
                            text = productList[index].rate,
                            style = TextStyle(
                                color = White,
                                fontSize = 12.sp,
                                fontFamily = soraFont,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                }

            }

            //Product Name
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                text = productList[index].name,
                style = TextStyle(
                    color = Black_Darkest,
                    fontSize = 16.sp,
                    fontFamily = soraFont,
                    fontWeight = FontWeight.SemiBold
                )
            )

            //Product Description
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                text = productList[index].description,
                style = TextStyle(
                    color = LightGray,
                    fontSize = 12.sp,
                    fontFamily = soraFont,
                    fontWeight = FontWeight.Normal
                )
            )

            Spacer(Modifier.height(8.dp))

            //Product Price & Plus Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //Product Price
                Text(
                    text = "$ ${productList[index].price}",
                    style = TextStyle(
                        color = Black_Darkest,
                        fontSize = 18.sp,
                        fontFamily = soraFont,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                //Product Icon
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    Icon(
                        modifier = Modifier.clickable {
                            if (viewModel.getShoppingCartProductList().contains(productList[index]))
                                viewModel.increaseCount(productList[index])
                            else {
                                viewModel.increaseCount(productList[index])
                                viewModel.addToShoppingCartProductList(productList[index])
                            }
                        },
                        painter = painterResource(R.drawable.ic_plus),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                }
            }

            Spacer(Modifier.height(8.dp))

        }

    }

}