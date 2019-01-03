package com.hasbihal.ui.chat

data class Chat(
        val id: Int,
        val userId: String,
        val message: String,
        val isMeSender: Boolean
)