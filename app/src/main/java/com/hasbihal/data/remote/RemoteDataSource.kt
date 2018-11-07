package com.hasbihal.data.remote

import com.hasbihal.data.IDataSource
import com.hasbihal.network.UserApi
import okhttp3.internal.Internal.instance
import retrofit2.Retrofit

class RemoteDataSource: IDataSource{

    override fun <T> getData(): T {
        TODO("not implemented")
    }


}