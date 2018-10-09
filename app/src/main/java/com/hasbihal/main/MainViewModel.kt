package com.hasbihal.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(context: Application): AndroidViewModel(context){
    private val list = MutableLiveData<String>()


    fun getList() : MutableLiveData<String> {
        list.value = "test1"
        list.value = "test2"
        list.value = "test3"

        return list
    }
}
