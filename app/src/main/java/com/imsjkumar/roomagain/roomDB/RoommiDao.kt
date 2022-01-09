package com.imsjkumar.roomagain.roomDB

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface RoommiDao {
    @Delete
    suspend fun deleteRoommi(roommiTable: RoommiTable)

    @Update
    suspend fun updateRoommi(roommiTable: RoommiTable)

    @Insert
    suspend fun insertRoommi(roommiTable: RoommiTable)

    @Query("SELECT * from sroid")

    fun getRoommiTable(): LiveData<List<RoommiTable>>

}