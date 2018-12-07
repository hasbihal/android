package com.hasbihal

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hasbihal.data.model.User
import com.hasbihal.data.repository.Repository
import com.hasbihal.data.response.Response

class FakeUserRepository(val context: Context) : Repository{

    private val RESPONSE_CODE = 0

    override fun getData(): Response {
        val usersJsonObject = loadJsonFile(context)

        val userList = Gson().fromJson(usersJsonObject, Array<User>::class.java).toList()

        return Response(
                code = RESPONSE_CODE,
                message = "successful",
                isSuccessful = true,
                body = userList)
    }
}