package com.mubaiwa.trust.umkhathi.feature.weather.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current")
data class CacheCurrentEntity(
        @ColumnInfo(name = "icon")
        val icon: String?,
        @ColumnInfo(name = "time")
        val time: Long,
        @ColumnInfo(name = "temperature")
        val temperature: Double,
        @ColumnInfo(name = "humidity")
        val humidity: Double,
        @ColumnInfo(name = "precipitation")
        val precipitation: Double,
        @ColumnInfo(name = "summary")
        val summary: String?,
        @ColumnInfo(name = "timeZone")
        val timeZone: String?
) {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int = 0
}