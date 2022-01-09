package com.imsjkumar.roomagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.imsjkumar.roomagain.roomDatabase.Contact
import com.imsjkumar.roomagain.roomDatabase.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import java.util.*

@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContactDatabase.getDatabase(this)
        var database2 = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDAO().insertContact(Contact(0, "imsjkumar", "9205618086", Date(), 1))
        }
    }

    fun getData(view: android.view.View) {
        database.contactDAO().getContact().observe(this, {
            Log.d("suraj", it.toString())
        })
    }
}