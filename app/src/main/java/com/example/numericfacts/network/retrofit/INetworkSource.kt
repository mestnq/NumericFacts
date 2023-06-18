package com.example.numericfacts.network.retrofit

import com.example.numericfacts.network.models.NumericInfoRequest
import retrofit2.Response

interface INetworkSource {
    suspend fun getTriviaInfo(num: Int): Response<NumericInfoRequest>
    suspend fun getMathInfo(num: Int): Response<NumericInfoRequest>
    suspend fun getDateInfo(month: Int, day: Int): Response<NumericInfoRequest>
}