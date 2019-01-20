package com.hasbihal

import android.widget.Button
import android.widget.EditText
import com.hasbihal.ui.chat.ChatActivity
import com.hasbihal.ui.chat.ChatViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hasbihal.ui.chat.Chat
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric


@RunWith(AndroidJUnit4::class)
class ChatViewModelTest {

    lateinit var chatViewModel : ChatViewModel

    @Before
    fun setup(){
        chatViewModel = ChatViewModel()
    }


    @Test
    fun successAddElementToList(){
        chatViewModel.sendMessage("Test 1")
        Assert.assertEquals(chatViewModel.getChats().value!!.size, 9)
    }
}