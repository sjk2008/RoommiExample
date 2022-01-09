package com.imsjkumar.roomagain.roomDB

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun fromDateToLong(value: Date):Long{
        return  value.time
    }
}