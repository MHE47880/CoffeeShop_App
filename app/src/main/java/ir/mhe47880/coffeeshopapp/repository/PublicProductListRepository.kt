package ir.mhe47880.coffeeshopapp.repository

import androidx.compose.runtime.mutableStateListOf
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import javax.inject.Inject

class PublicProductListRepository @Inject constructor() {

    companion object {
        var shoppingCartProductList = mutableStateListOf<CoffeeInfo>()
    }

    fun clearList() {
        shoppingCartProductList.forEach { it.count = 0 }
        shoppingCartProductList.clear()
    }

}