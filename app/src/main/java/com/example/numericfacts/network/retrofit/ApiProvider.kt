package com.example.numericfacts.network.retrofit

import com.example.numericfacts.domain.api.Api

class ApiProvider(private val client: RetrofitClient) {
    private val baseApiUrl = "http://numbersapi.com/";
    fun getApi(): Api =
        client.getClient(baseApiUrl)
            .create(Api::class.java)
}