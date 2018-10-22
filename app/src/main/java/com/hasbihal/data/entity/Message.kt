package com.hasbihal.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "Message")
data class Message constructor(
        @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
        @ColumnInfo(name = "message") var message: String,
        @ColumnInfo(name = "to")      var to: Int,
        @ColumnInfo(name = "from")    var from: Int,
        @ColumnInfo(name = "date")    var date: Date,
        @ColumnInfo(name = "isRead")  var isRead: Boolean
    ){
}