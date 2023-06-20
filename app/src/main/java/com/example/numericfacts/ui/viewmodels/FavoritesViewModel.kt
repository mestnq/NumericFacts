package com.example.numericfacts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numericfacts.domain.data.NumericInfo
import com.example.numericfacts.domain.usecases.GetNumericInfoList
import com.example.numericfacts.ui.model.Item
import com.example.numericfacts.ui.model.toItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val getNumericInfoList: GetNumericInfoList
) : ViewModel() {

    val liveData = MutableLiveData<MutableList<Item>?>()

    init {
        viewModelScope.launch {
            val list: List<NumericInfo> = getNumericInfoList()
            val result = mutableListOf<Item>()
            result.addAll(list.map { it.toItem() })
            liveData.postValue(result.toMutableList())
        }
    }


}