package com.hasbihal.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasbihal.R
import kotlinx.android.synthetic.main.activity_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModel()
    private val adapter by lazy { UserListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        lstMainOfUser.layoutManager = LinearLayoutManager(this)
        lstMainOfUser.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lstMainOfUser.adapter = adapter

        viewModel.loadUsers().observe(this, Observer {
            adapter.updateUsers(it)
        })
    }
}
