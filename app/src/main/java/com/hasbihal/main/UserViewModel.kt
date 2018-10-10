package com.hasbihal.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val list = MutableLiveData<MainModel>()


    fun getList() : MutableLiveData<String> {
        list.value = "test1"
        list.value = "test2"
        list.value = "test3"

        return list
    }
}
