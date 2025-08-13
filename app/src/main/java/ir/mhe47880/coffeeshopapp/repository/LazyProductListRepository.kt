package ir.mhe47880.coffeeshopapp.repository

import ir.mhe47880.coffeeshopapp.model.local.utils.FakeCoffeeData
import ir.mhe47880.coffeeshopapp.viewmodel.CustomTopAppBarViewModel
import jakarta.inject.Inject

class LazyProductListRepository @Inject constructor() {

    companion object {
        val filteredItems =
            FakeCoffeeData.coffeeDataList.filter {
                it.name.trim().lowercase().contains(CustomTopAppBarViewModel.textFieldValue.trim().lowercase())
            }
    }

}