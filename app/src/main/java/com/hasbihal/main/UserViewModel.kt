package com.hasbihal.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.model.User
import com.hasbihal.data.repository.Repository
import com.hasbihal.data.repository.UserRepository

class UserViewModel(private val repo: Repository): ViewModel() {

    private var list = MutableLiveData<List<User>>()

    fun loadUsers() : LiveData<List<User>> {
        val response = repo.getData().body
        list.value = response.
        return list
    }
}
