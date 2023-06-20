package com.example.numericfacts.domain.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.numericfacts.domain.data.NumericInfoDbEntity

@Dao
interface ServiceDao {
    @Query("UPDATE numeric_info SET is_favorites = true WHERE id = :id;")
    suspend fun addToFavorites(id: Long)

    @Insert
    suspend fun saveNumericInfo(numericInfoDbEntity: NumericInfoDbEntity)

    @Query("SELECT * FROM numeric_info")
    suspend fun getAllNumericIfo(): List<NumericInfoDbEntity>?
    @Query("SELECT * FROM numeric_info WHERE id = :id")
    suspend fun getNumericIfo(id: Long): NumericInfoDbEntity?
}