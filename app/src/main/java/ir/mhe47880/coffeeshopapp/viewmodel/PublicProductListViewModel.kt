package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.repository.PublicProductListRepository
import ir.mhe47880.coffeeshopapp.repository.PublicProductListRepository.Companion.shoppingCartProductList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PublicProductListViewModel @Inject constructor(
    val repository: PublicProductListRepository
) : ViewModel() {

    val deliveryFee = "2.0"

    val deliveryDiscount = 1.0

    val deliveryFeeForShown = deliveryFee.toDouble() - deliveryDiscount

    val getShoppingCartProductList = shoppingCartProductList

    private var _totalPrice = MutableStateFlow(
        getShoppingCartProductList.sumOf {
            it.price.toDouble() * it.count
        } + deliveryFee.toDouble()
    )
    val totalPrice: StateFlow<Double> = _totalPrice

    fun getCountState(index: Int) = mutableIntStateOf(getShoppingCartProductList[index].count)

    fun updateTotalPrice() {
        _totalPrice.value =
            getShoppingCartProductList.sumOf { it.price.toDouble() * it.count } + deliveryFee.toDouble()
    }

    fun addToShoppingCartProductList(item: CoffeeInfo) =
        getShoppingCartProductList.add(item)

    fun clearShoppingCartProductList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearList()
        }
    }

    fun increaseCount(item: CoffeeInfo) = item.count++

    fun decreaseCount(item: CoffeeInfo) = item.count--

}