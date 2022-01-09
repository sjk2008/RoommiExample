package com.imsjkumar.roomagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imsjkumar.roomagain.roomDB.RoommiDataBase
import com.imsjkumar.roomagain.roomDB.RoommiTable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var database:RoommiDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database=RoommiDataBase.getDatabase(this)
        var database2= RoommiDataBase.getDatabase(this)

        GlobalScope.launch {
            database.RoommiDao().insertRoommi(RoommiTable(0,"Suraj","9205618086", Date()))
        }

    }
}