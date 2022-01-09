package com.imsjkumar.roomagain.roomDatabase

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.*

class Converters {

    //converters portion h values ko convert krne ke lie new kotlin Class h
    @TypeConverter
    fun fromDateToLong(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun fromLongToDate(value: Long): Date {
        return Date(value)
    }

}