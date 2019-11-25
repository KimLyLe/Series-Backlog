package com.example.seriesbacklog.model

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.util.*

class Converters {

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return if (value == null) {
            null
        } else {
            LocalDateTime.parse(value)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }

}