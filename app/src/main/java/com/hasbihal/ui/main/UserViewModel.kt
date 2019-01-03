package com.hasbihal.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasbihal.data.model.User
import com.hasbihal.data.repository.Repository

class UserViewModel(private val repo: Repository): ViewModel() {

    private var list = MutableLiveData<List<User>>()

    fun loadUsers() : LiveData<List<User>> {
        val response = repo.getData().body as List<User>
        list.value = response
        return list
    }
}
