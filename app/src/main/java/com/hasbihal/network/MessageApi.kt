package com.hasbihal.network

import com.hasbihal.data.model.Messages
import retrofit2.Call
import retrofit2.http.POST

interface MessageApi {
    @POST("message")
    fun getMessage(): Call<Messages>
}