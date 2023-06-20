package com.example.numericfacts.domain.data

import com.google.gson.annotations.SerializedName

data class NumericInfo(
    @SerializedName("id")
    val id: Long,
    @SerializedName("text")
    val text: String,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("number")
    val number: Int,
    @SerializedName("found")
    val found: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("isFavorites")
    val isFavorites: Boolean
)