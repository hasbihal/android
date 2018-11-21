package com.hasbihal.data.repository

import com.hasbihal.data.model.User
import com.hasbihal.network.UserApi
import retrofit2.Call

class UserRepository(private val userApi: UserApi){

    fun getData(): Call<List<User>> {
        return userApi.getUsers()
    }
}