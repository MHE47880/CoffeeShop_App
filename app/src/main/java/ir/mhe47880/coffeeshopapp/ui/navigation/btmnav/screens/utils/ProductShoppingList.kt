package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.R
import ir.mhe47880.coffeeshopapp.ui.theme.BlackDarkest
import ir.mhe47880.coffeeshopapp.ui.theme.LightGray
import ir.mhe47880.coffeeshopapp.ui.theme.soraFont
import ir.mhe47880.coffeeshopapp.viewmodel.PublicProductListViewModel

@Composable
fun ProductShoppingList(
    index: Int,
    viewModel: PublicProductListViewModel = hiltViewModel()
) {

    val itemsList = viewModel.getShoppingCartProductList()

    var countState by remember { mutableIntStateOf(viewModel.getShoppingCartProductList()[index].count) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(itemsList[index].imageAddress),
            contentDescription = itemsList[index].name,
            contentScale = ContentScale.FillBounds
        )

        //Product Name & Description
        Column(
            modifier = Modifier.padding(start = 16.dp),
        ) {

            Text(
                modifier = Modifier.sizeIn(maxWidth = 120.dp),
                text = itemsList[index].name,
                style = TextStyle(
                    color = BlackDarkest,
                    fontFamily = soraFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                modifier = Modifier.sizeIn(maxWidth = 120.dp),
                text = itemsList[index].description,
                style = TextStyle(
                    color = LightGray,
                    fontFamily = soraFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(
                        enabled = countState > 1,
                        onClick = {
                            viewModel.decreaseCount(itemsList[index])
                            countState--
                            viewModel.updateTotalPrice()
                        }
                    ),
                painter = painterResource(
                    if (countState == 1) R.drawable.ic_minus_disable else R.drawable.ic_minus_enable
                ),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = countState.toString(),
                style = TextStyle(
                    color = BlackDarkest,
                    fontFamily = soraFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            )

            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(
                        enabled = countState < 10,
                        onClick = {
                            viewModel.increaseCount(itemsList[index])
                            countState++
                            viewModel.updateTotalPrice()
                        }
                    ),
                painter = painterResource(
                    if (countState != 10) R.drawable.ic_plus_2_enable else R.drawable.ic_plus_2_disable
                ),
                contentDescription = null,
                tint = Color.Unspecified,
            )

        }

    }
}