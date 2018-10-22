package com.hasbihal.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hasbihal.data.entity.Message

@Database(entities = [Message::class], version = 1)
abstract class HasbihalDatabase: RoomDatabase() {
    companion object {

        private var INSTANCE: HasbihalDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): HasbihalDatabase {
            synchronized(lock){
                if (INSTANCE == null){
                    INSTANCE = Room
                            .databaseBuilder(context.applicationContext,
                                             HasbihalDatabase::class.java,
                                      "HDatabase.db")
                            .build()
                }

                return INSTANCE!!
            }
        }

    }
}