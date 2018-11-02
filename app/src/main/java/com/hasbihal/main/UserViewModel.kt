package com.hasbihal.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.model.UserEntity
import com.hasbihal.data.repository.UserRepository

class UserViewModel(private val repo: UserRepository): ViewModel() {

    private var list = MutableLiveData<List<UserEntity>>()

    fun loadUsers() : LiveData<List<UserEntity>> {
        list = repo.getData()
        return list
    }
}
