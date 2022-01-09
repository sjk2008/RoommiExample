package com.imsjkumar.roomagain.roomDB

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "Sroid")
data class RoommiTable(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "Name")
    var name: String,
    @ColumnInfo(name = "phone")
    var phone: String,
    @ColumnInfo(name = "date")
    var date: Date
)
