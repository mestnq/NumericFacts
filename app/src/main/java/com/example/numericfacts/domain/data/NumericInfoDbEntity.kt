package com.example.numericfacts.domain.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "numeric_info")
data class NumericInfoDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "text_info") val text: String?,
    @ColumnInfo(name = "year") val year: Int?,
    @ColumnInfo(name = "number") val number: Int?,
    @ColumnInfo(name = "found") val found: Boolean?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "is_favorites") val isFavorites: Boolean?
) {
}