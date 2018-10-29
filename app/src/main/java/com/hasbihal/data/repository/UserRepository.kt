package com.hasbihal.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hasbihal.data.model.UserEntity
import com.hasbihal.data.remote.RemoteDataSource

class UserRepository(val dataSource: RemoteDataSource){

    fun getData(): MutableLiveData<List<UserEntity>> {
        return MutableLiveData<List<UserEntity>>()
    }
}