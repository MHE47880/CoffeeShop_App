package ir.mhe47880.coffeeshopapp.model.local

import androidx.annotation.DrawableRes

data class CoffeeInfo(
    val id: Int,
    @DrawableRes val imageAddress: Int,
    val name: String,
    val description: String,
    val price: String,
    val rate: String,
    var count: Int = 0
)