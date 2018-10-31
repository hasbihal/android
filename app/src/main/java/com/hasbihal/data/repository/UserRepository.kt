package com.hasbihal.data.repository

import androidx.lifecycle.MutableLiveData
import com.hasbihal.data.model.UserEntity
import com.hasbihal.data.IDataSource

class UserRepository(val dataSource: IDataSource){

    fun getData(): MutableLiveData<List<UserEntity>> {
        return dataSource.getData()
    }
}