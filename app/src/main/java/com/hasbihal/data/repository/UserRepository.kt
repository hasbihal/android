package com.hasbihal.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hasbihal.data.model.UserEntity

class UserRepository{

    fun getData(): MutableLiveData<List<UserEntity>> {
        return MutableLiveData<List<UserEntity>>()
    }
}