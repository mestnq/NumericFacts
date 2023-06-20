package com.example.numericfacts.domain.usecases

import com.example.numericfacts.domain.data.NumericInfo

interface GetNumericInfo {
    suspend operator fun invoke(id: Long): NumericInfo?
}