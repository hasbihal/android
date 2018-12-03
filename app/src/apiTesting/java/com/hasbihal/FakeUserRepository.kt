package com.hasbihal

import android.content.Context
import com.hasbihal.data.repository.Repository
import com.hasbihal.data.response.Response

class FakeUserRepository(val context: Context) : Repository{

    private val RESPONSE_CODE = 0

    override fun getData(): Response {
        val usersJsonObject = loadJsonFile(context, "users.json")

        return Response(
                code = RESPONSE_CODE,
                message = "successful",
                isSuccessful = true,
                body = usersJsonObject)
    }
}