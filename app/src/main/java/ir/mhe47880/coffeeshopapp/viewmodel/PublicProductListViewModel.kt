package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.repository.PublicProductListRepository.Companion.shoppingCartProductList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PublicProductListViewModel @Inject constructor() : ViewModel() {

    val deliveryFee = "2.0"

    val deliveryDiscount = 1.0

    val deliveryFeeForShown = deliveryFee.toDouble() - deliveryDiscount

    private var _totalPrice = MutableStateFlow(
        getShoppingCartProductList().sumOf {
            it.price.toDouble() * it.count
        } + deliveryFee.toDouble()
    )
    val totalPrice: StateFlow<Double> = _totalPrice

    fun updateTotalPrice() {
        _totalPrice.value =
            getShoppingCartProductList().sumOf { it.price.toDouble() * it.count } + deliveryFee.toDouble()
    }

    fun getShoppingCartProductList() = shoppingCartProductList

    fun addToShoppingCartProductList(item: CoffeeInfo) =
        getShoppingCartProductList().add(item)

    //TODO Add this feature
    fun removeFromShoppingCartProductList(item: CoffeeInfo) =
        getShoppingCartProductList().remove(item)

    fun increaseCount(item: CoffeeInfo) = item.count++

    fun decreaseCount(item: CoffeeInfo) = item.count--

}