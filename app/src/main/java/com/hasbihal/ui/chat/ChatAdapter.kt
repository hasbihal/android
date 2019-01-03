package com.hasbihal.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasbihal.R
import kotlinx.android.synthetic.main.item_chat_to.view.*

class ChatAdapter : RecyclerView.Adapter<ChatHolder>() {

    private lateinit var list: MutableList<Chat>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        return ChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_to, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        holder.itemView.txtMessage.text = list[position].message
    }

    fun setList(list: List<Chat>){
        this.list.clear()
        this.list.addAll(list)
    }
}