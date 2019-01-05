package com.hasbihal.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasbihal.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        adapter = ChatAdapter()
        adapter.setList( getDummyData() )

        lstChat.layoutManager = LinearLayoutManager(this)
        lstChat.adapter = adapter


    }

    private fun getDummyData(): List<Chat> {
        var list = mutableListOf<Chat>()

        list.add(Chat(1,"1","deneme 1",false))
        list.add(Chat(1,"1","deneme 2",true))
        list.add(Chat(1,"1","deneme 3",false))
        list.add(Chat(1,"1","deneme 4",true))
        list.add(Chat(1,"1","deneme 5",false))
        list.add(Chat(1,"1","deneme 6",true))
        list.add(Chat(1,"1","deneme 7",false))
        list.add(Chat(1,"1","deneme 8",true))

        return list
    }
}
