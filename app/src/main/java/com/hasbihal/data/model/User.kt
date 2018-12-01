package com.hasbihal.data.model

data class User(
        val id: Int,
        val name: String,
        val summary: String,
        val photoUrl: String,
        val avatar: String,
        val location: String,
        val email: String,
        val gender: String
)