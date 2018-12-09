package com.hasbihal

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hasbihal.data.model.User
import com.hasbihal.data.repository.Repository
import com.hasbihal.data.response.Response
import java.lang.reflect.Type

class FakeUserRepository(val context: Context) : Repository{

    private val RESPONSE_CODE = 0

    override fun getData(): Response {
        val usersJsonObject = loadJsonFile(context).getJSONArray("data")

        val userList : List<User> = Gson().fromJson(usersJsonObject.toString(), Array<User>::class.java).toMutableList()

        return Response(
                code = RESPONSE_CODE,
                message = "successful",
                isSuccessful = true,
                body = userList)
    }
}