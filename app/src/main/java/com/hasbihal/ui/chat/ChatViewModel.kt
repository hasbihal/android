package com.hasbihal.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel() {

    private var chats = MutableLiveData<ArrayList<Chat>>()
    private val chatList  = ArrayList<Chat>()

    init {
        chatList.add(Chat(1,"1","deneme 1",false))
        chatList.add(Chat(1,"1","deneme 2",true))
        chatList.add(Chat(1,"1","deneme 3",false))
        chatList.add(Chat(1,"1","deneme 4",true))
        chatList.add(Chat(1,"1","deneme 5",false))
        chatList.add(Chat(1,"1","deneme 6",true))
        chatList.add(Chat(1,"1","deneme 7",false))
        chatList.add(Chat(1,"1","deneme 8",true))

        chats.postValue(chatList)
    }

    fun getChats() : LiveData<ArrayList<Chat>> {
        return chats
    }

    fun sendMessage(message: String){
        chatList.add(Chat(1,"1",message,false))
        chats.postValue(chatList)
    }
}