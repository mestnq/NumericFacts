package com.example.numericfacts.domain.usecases

import com.example.numericfacts.domain.data.NumericInfo

interface GetNumericInfoList {
    suspend operator fun invoke(): List<NumericInfo>
}