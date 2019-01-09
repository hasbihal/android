package com.hasbihal.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasbihal.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    private lateinit var adapter: ChatAdapter
    private lateinit var viewModel: ChatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        adapter = ChatAdapter()

        viewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        viewModel.getChats().observe(this, Observer {
            adapter.setList(it)
        })

        lstChat.layoutManager = LinearLayoutManager(this)
        lstChat.adapter = adapter
    }
}
