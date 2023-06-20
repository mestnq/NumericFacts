package com.example.numericfacts.domain.usecases

import com.example.numericfacts.domain.data.NumericInfo
import com.example.numericfacts.domain.repositories.CacheRepository
import javax.inject.Inject

class GetNumericInfoImpl @Inject constructor(
    private val cacheRepository: CacheRepository,
) : GetNumericInfo {

    override suspend fun invoke(id: Long): NumericInfo? {
        return cacheRepository.getNumericIfo(id)?.toNumericInfo()
    }
}
