package com.example.numericfacts.domain.usecases

import com.example.numericfacts.domain.data.NumericInfo
import com.example.numericfacts.domain.data.NumericInfoDbEntity
import com.example.numericfacts.domain.repositories.CacheRepository
import javax.inject.Inject

class GetNumericInfoListImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
) : GetNumericInfoList {
    override suspend fun invoke(): List<NumericInfo> {
        val response: List<NumericInfo>? = cacheRepository.getAllNumericIfo()?.map(NumericInfoDbEntity::toNumericInfo)
        return response ?: emptyList()
    }
}