package com.hasbihal.data.repository


import com.hasbihal.Hasbihal
import com.hasbihal.R
import com.hasbihal.data.response.Response
import com.hasbihal.network.UserApi

class UserRepository(private val userApi: UserApi) : Repository {

    override fun getData(): Response {
        val serviceResponse = userApi.getUsers().execute()


        // TODO : refactor for errors
        if(serviceResponse.isSuccessful)
        {
            return Response(
                    code = serviceResponse.code(),
                    message = serviceResponse.message(),
                    isSuccessful = serviceResponse.isSuccessful,
                    body = serviceResponse.body()!!
                    )
        }
    }

}