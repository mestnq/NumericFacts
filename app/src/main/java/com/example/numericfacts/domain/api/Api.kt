package com.example.numericfacts.domain.api

import com.example.numericfacts.network.models.NumericInfoRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("{month}/{day}/date?json")
    fun getDate(@Path("month") month: Int, @Path("day") day: Int): Call<NumericInfoRequest>

    @GET("{number}/math?json")
    fun getMath(@Path("number") number: Int): Call<NumericInfoRequest>

    @GET("{number}?json")
    fun getTrivia(@Path("number") number: Int): Call<NumericInfoRequest>
}