package com.imsjkumar.roomagain.roomDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.imsjkumar.roomagain.roomDatabase.Contact

@Dao
interface ContactDao {


    //suspend :- we use suspend because we do not want our data on the main activity
    //we just want to execute our data in background

    //IN-SHORT //insists of getting our data in mainActivity we want it to run in background while our mainActivity is busy
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    //we want to select the data
    @Query("SELECT * from contact")
    //LiveData if we are using (LiveData)Keyword then we do not have to use suspend(keyword)
    fun getContact(): LiveData<List<Contact>>//Converters kotlin class
    //to execute in background thread we use coroutine
}
//After completing your work here move to the ContactDatabase