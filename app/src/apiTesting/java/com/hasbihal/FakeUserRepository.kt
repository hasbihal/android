package com.hasbihal

import com.hasbihal.data.model.User
import com.hasbihal.network.UserApi
import okio.Okio
import retrofit2.Call
import java.io.IOException

class FakeUserRepository(private val userApi: UserApi){


    fun getData(): Call<List<User>> {
        return userApi.getUsers()
    }
}