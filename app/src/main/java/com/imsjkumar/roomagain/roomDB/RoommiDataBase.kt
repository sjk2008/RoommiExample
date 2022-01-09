package com.imsjkumar.roomagain.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [RoommiTable::class], version = 1)
@TypeConverters(Converter::class)
abstract class RoommiDataBase : RoomDatabase() {
    abstract fun RoommiDao():RoommiDao


    @Volatile
    private var INSTANCE: RoommiDataBase?=null


    @InternalCoroutinesApi
    fun getDatabase(context: Context):RoommiDataBase{

        if (INSTANCE == null){
            synchronized(true){
            INSTANCE=Room.databaseBuilder(
            context.applicationContext,
            RoommiDataBase::class.java,"roommiDB")
                //add migration here
                .build()
            }
        }

        return INSTANCE!!
    }
}