package com.imsjkumar.roomagain.roomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//First design the structure what you want to add in room db
//Means create list here and then move to the "contactDao"

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    val phone: String,
    val createdDate: Date,
    val isActive: Int
)
