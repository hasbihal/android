package com.hasbihal.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.hasbihal.R
import kotlinx.android.synthetic.main.activity_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()
    lateinit var adapter  : UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        viewModel.loadUsers().observe(this, Observer {
            adapter = UserListAdapter(applicationContext, it, R.layout.item_user_list)
            lstMainOfUser.adapter = adapter
        })
    }
}
