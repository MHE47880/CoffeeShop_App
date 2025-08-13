package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.repository.PublicProductListRepository.Companion.shoppingCartProductList
import javax.inject.Inject

@HiltViewModel
class PublicProductListViewModel @Inject constructor() : ViewModel() {

    fun getShoppingCartProductList() = shoppingCartProductList

    fun addToShoppingCartProductList(item: CoffeeInfo) =
        getShoppingCartProductList().add(item)

    fun removeFromShoppingCartProductList(item: CoffeeInfo) =
        getShoppingCartProductList().remove(item)

}