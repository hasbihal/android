package com.hasbihal.data.local.dao

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hasbihal.data.entity.Message

@Dao
interface MessageDao {

    // This should be reconfigured
    @Query("SELECT * FROM Message WHERE sender = id ORDER BY date DESC")
    fun all(id: Int): LiveData<List<Message>>

    @Insert
    fun add(vararg message: Message)

    @Delete
    fun delete(vararg message: Message)
}