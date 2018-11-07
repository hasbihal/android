package com.hasbihal.network

import com.hasbihal.data.model.User
import retrofit2.Call
import retrofit2.http.POST

interface UserApi {
    @POST("users")
    fun getUsers(): Call<List<User>>
}