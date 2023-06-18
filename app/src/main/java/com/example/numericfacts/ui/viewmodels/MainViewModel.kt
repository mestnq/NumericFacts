package com.example.numericfacts.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.numericfacts.domain.data.NumericInfo
import com.example.numericfacts.network.LoadingResult
import com.example.numericfacts.network.retrofit.ApiNetworkSource
import com.example.numericfacts.network.retrofit.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<LoadingResult<NumericInfo>?>()
    private val network: INetworkSource = ApiNetworkSource()

    fun init(type: String, num1: Int, num2: Int) { //todo: получше придумать
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                when (type) {
                    "math" -> {
                        network.getMathInfo(num1)
                    }
                    "date" -> {
                        network.getDateInfo(num2, num1)
                    }
                    else -> /*if(type == "trivia")*/ { //todo exc?
                        network.getTriviaInfo(num1)
                    }
                }
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val numericInfo = responses?.let { NumericInfo.getTool(it) }
                liveData.postValue(LoadingResult.Success(numericInfo))
            } else {
                liveData.postValue(LoadingResult.Failure("internet error", "check your internet connection"))
            }
        }
    }
}
