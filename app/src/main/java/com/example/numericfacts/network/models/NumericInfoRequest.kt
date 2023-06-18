package com.example.numericfacts.network.models

import com.google.gson.annotations.SerializedName

data class NumericInfoRequest(
    @SerializedName("text")
    val text: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("found")
    val found: Boolean,
    @SerializedName("type")
    val type: String,
)

// Example
//{
//    "text": "5 is the third prime number.",
//    "number": 5,
//    "found": true,
//    "type": "math"
//}

// Example
//{
//    "text": "42 is the answer to the Ultimate Question of Life, the Universe, and Everything.",
//    "number": 42,
//    "found": true,
//    "type": "trivia"
//}