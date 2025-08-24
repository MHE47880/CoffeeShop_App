package ir.mhe47880.coffeeshopapp.repository

import ir.mhe47880.coffeeshopapp.model.local.CoffeeInfo
import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import javax.inject.Inject

class HomeScreenRepository @Inject constructor() {

    fun getCoffeeList(): List<CoffeeInfo> = FakeCoffeeData.coffeeDataList

}
