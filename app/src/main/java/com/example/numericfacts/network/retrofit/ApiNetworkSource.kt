package com.example.numericfacts.network.retrofit

import com.example.numericfacts.network.models.NumericInfoRequest
import retrofit2.Response

class ApiNetworkSource : INetworkSource {
    override suspend fun getTriviaInfo(num: Int): Response<NumericInfoRequest> {
        return ApiProvider(RetrofitClient()).getApi().getTrivia(num).execute()
    }

    override suspend fun getMathInfo(num: Int): Response<NumericInfoRequest> {
        return ApiProvider(RetrofitClient()).getApi().getMath(num).execute()
    }

    override suspend fun getDateInfo(month: Int, day: Int): Response<NumericInfoRequest> {
        return ApiProvider(RetrofitClient()).getApi().getDate(month, day).execute()
    }
}