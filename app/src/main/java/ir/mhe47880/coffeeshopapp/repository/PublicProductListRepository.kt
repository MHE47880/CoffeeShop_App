package ir.mhe47880.coffeeshopapp.repository

import androidx.compose.runtime.mutableStateListOf
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo

class PublicProductListRepository {

    companion object {
        val shoppingCartProductList = mutableStateListOf<CoffeeInfo>()
    }

}