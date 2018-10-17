package com.hasbihal.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hasbihal.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListActivity : AppCompatActivity() {

    val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        //val model = ViewModelProviders.of(this).get(UserViewModel::class.java)

        Log.d("UserListActivity", "test is :"+userViewModel.testRepo())

    }
}
