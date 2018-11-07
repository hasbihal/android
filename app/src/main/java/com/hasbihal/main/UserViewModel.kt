package com.hasbihal.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.model.User
import com.hasbihal.data.repository.UserRepository

class UserViewModel(private val repo: UserRepository): ViewModel() {

    private var list = MutableLiveData<List<User>>()

    fun loadUsers() : LiveData<List<User>> {
        val response = repo.getData().execute()
        list.value = response.body()
        return list
    }
}
