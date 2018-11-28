package com.hasbihal

import android.content.Context
import com.hasbihal.data.repository.Repository
import com.hasbihal.data.response.Response

class FakeUserRepository(val context: Context) : Repository{

/*
*
*
* {
      "avatar": null,
      "email": "asfas@gmail.com",
      "gender": "both",
      "id": 23,
      "location": "istanbul",
      "name": "asfas",
      "summary": "developer"
    }
*
*
*
* */


    override fun getData(): Response {
        val usersJsonObject = loadJsonFile(context, "users.json")

        return Response
    }
}