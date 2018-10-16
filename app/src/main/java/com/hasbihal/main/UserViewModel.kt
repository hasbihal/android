package com.hasbihal.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.entity.UserEntity

class UserViewModel: ViewModel() {
    private val list = MutableLiveData<UserEntity>()


    fun loadUsers() : MutableLiveData<UserEntity> {
        return list
    }


}
