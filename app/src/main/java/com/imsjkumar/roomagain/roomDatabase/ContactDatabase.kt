package com.imsjkumar.roomagain.roomDatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Contact::class], version = 2)
//yaha version ka use is liye hua h taki jb bhi hm apne application ko update kre us smy
// updated version sbhi users ke pass aa jana chahiye isilie hm version=2 ka use krte
// h or yaha pe starting version =1 hoga isko update kr lena
@TypeConverters(Converters::class)

abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDao


    //here re-write (version = 1) at the top and
    //do not use this companion object as per now
    //basically ye migration wala task h
    companion object {

        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }
        //kuch bhi value assign hoti h wo sbko pata chal jata h

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                //to create one instance we use synchronize
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    ).addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}

//yaha se MainActivity pe jake isko call kr dena