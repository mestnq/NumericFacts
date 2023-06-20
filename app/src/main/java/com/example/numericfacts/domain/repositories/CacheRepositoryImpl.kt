package com.example.numericfacts.domain.repositories

import com.example.numericfacts.domain.data.NumericInfoDbEntity
import com.example.numericfacts.domain.room.ServiceDao
import javax.inject.Inject


class CacheRepositoryImpl  @Inject constructor(
    private val cacheService: ServiceDao
) : CacheRepository {
    override suspend fun addToFavorites(id: Long) = cacheService.addToFavorites(id)

    override suspend fun saveNumericInfo(infoDbEntity: NumericInfoDbEntity) {
        cacheService.saveNumericInfo(infoDbEntity)
    }

    override suspend fun getAllNumericIfo(): List<NumericInfoDbEntity>? = cacheService.getAllNumericIfo()

    override suspend fun getNumericIfo(id: Long): NumericInfoDbEntity? = cacheService.getNumericIfo(id)
}
