package com.example.numericfacts.network

import com.example.numericfacts.domain.data.NumericInfo

sealed class LoadingResult<out T> {
    data class Success<out R>(val value: NumericInfo?): LoadingResult<R>()
    data class Failure(
        val message: String?,
        val moreInfo: String?
    ): LoadingResult<Nothing>()
}