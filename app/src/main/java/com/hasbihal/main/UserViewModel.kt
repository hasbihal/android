package com.hasbihal.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    private val list = MutableLiveData<User>()


    fun loadUsers() : MutableLiveData<User> {
        return list
    }


}
