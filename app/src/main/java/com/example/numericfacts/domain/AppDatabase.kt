package com.example.numericfacts.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.numericfacts.domain.data.NumericInfoDbEntity
import com.example.numericfacts.domain.room.ServiceDao

@Database(
    version = 1,
    entities = [
        NumericInfoDbEntity::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getServiceDao(): ServiceDao
}
