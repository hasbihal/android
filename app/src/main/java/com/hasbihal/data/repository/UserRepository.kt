package com.hasbihal.data.repository

import androidx.lifecycle.MutableLiveData
import com.hasbihal.data.model.User
import com.hasbihal.data.IDataSource

class UserRepository(val dataSource: IDataSource){

    fun getData(): MutableLiveData<List<User>> {
        return dataSource.getData()
    }
}