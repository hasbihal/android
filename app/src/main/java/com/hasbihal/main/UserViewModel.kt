package com.hasbihal.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.model.UserEntity
import com.hasbihal.data.repository.IRepository

class UserViewModel(private val repo: IRepository): ViewModel() {
    private val list = MutableLiveData<UserEntity>()


    fun loadUsers() : MutableLiveData<UserEntity> {
        return list
    }

    fun testRepo(): String {
        return repo.getData()
    }

}
