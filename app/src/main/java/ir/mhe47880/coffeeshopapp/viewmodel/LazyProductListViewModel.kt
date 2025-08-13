package ir.mhe47880.coffeeshopapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mhe47880.coffeeshopapp.repository.LazyProductListRepository.Companion.filteredItems
import javax.inject.Inject

@HiltViewModel
class LazyProductListViewModel @Inject constructor() : ViewModel() {

    val checkItems = getFilteredItems().isNotEmpty()

    private val _columnCount = if (checkItems) 2 else 1
    val columnCount: Int
        get() = _columnCount

    fun getFilteredItems() = filteredItems


}