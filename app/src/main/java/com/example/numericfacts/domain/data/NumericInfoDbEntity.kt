package com.example.numericfacts.domain.data

import androidx.room.*

@Entity(tableName = "numeric_info")
data class NumericInfoDbEntity(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "text_info") val text: String,
    @ColumnInfo(name = "year") val year: Int?,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "found") val found: Boolean,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "is_favorites") val isFavorites: Boolean
) {
    fun toNumericInfo(): NumericInfo = NumericInfo(
        id = 0,
        year = year,
        found = found,
        isFavorites = isFavorites,
        number = number,
        text = text,
        type = type
    )

    companion object {
        fun fromNumericInfo(numericInfo: NumericInfo) = NumericInfoDbEntity(
            id = numericInfo.id,
            text = numericInfo.text,
            year = numericInfo.year,
            number = numericInfo.number,
            found = numericInfo.found,
            type = numericInfo.type,
            isFavorites = numericInfo.isFavorites
        )
    }
}
