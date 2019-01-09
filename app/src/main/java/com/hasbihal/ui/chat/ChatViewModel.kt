package com.hasbihal.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel() {

    private val chats = MutableLiveData<List<Chat>>()

    fun getChats() : LiveData<List<Chat>> {
        val list = ArrayList<Chat>()

        list.add(Chat(1,"1","deneme 1",false))
        list.add(Chat(1,"1","deneme 2",true))
        list.add(Chat(1,"1","deneme 3",false))
        list.add(Chat(1,"1","deneme 4",true))
        list.add(Chat(1,"1","deneme 5",false))
        list.add(Chat(1,"1","deneme 6",true))
        list.add(Chat(1,"1","deneme 7",false))
        list.add(Chat(1,"1","deneme 8",true))

        chats.value = list

        return chats
    }
}