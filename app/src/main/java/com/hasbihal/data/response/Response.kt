package com.hasbihal.data.response

data class Response(
    val code: Int,
    val message: String = "",
    val isSuccessful: Boolean,
    val body: Any
)

