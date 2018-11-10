package com.hasbihal.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.hasbihal.data.entity.Message

@Dao
interface MessageDao {

    @Query("SELECT * FROM Message WHERE sender = id ORDER BY date DESC")
    fun all(id: Int): LiveData<List<Message>>
}