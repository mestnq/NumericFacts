package com.example.numericfacts.domain.repositories

import com.example.numericfacts.domain.data.NumericInfoDbEntity


interface CacheRepository {
    suspend fun addToFavorites(id: Long)

    suspend fun getAllNumericIfo(): List<NumericInfoDbEntity>?
    suspend fun getNumericIfo(id: Long): NumericInfoDbEntity?
    suspend fun saveNumericInfo(infoDbEntity: NumericInfoDbEntity)
}