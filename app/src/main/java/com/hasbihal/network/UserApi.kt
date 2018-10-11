package com.hasbihal.network

import com.hasbihal.main.User
import retrofit2.Call
import retrofit2.http.POST

interface UserApi {
    @POST("users")
    fun getUsers(): Call<User>
}