package ir.mhe47880.coffeeshopapp.ui.navigation.btmnav.screens.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.mhe47880.coffeeshopapp.viewmodel.PublicProductListViewModel

@Composable
fun LazyShoppingCartProductList(
    viewModel: PublicProductListViewModel = hiltViewModel()
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

    ) {

        for (i in 0..viewModel.getShoppingCartProductList().lastIndex){
            ProductShoppingList(index = i)
        }

    }
}