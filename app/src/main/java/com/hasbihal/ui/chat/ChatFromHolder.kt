package com.hasbihal.ui.chat

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat_from.view.*

class ChatFromHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Chat) = with(itemView) {
        txtMessage.text = item.message
    }
}