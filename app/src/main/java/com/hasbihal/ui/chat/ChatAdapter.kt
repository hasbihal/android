package com.hasbihal.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasbihal.R
import kotlinx.android.synthetic.main.item_chat_to.view.*

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(list[viewType].isMeSender){
            ChatToHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_to, parent, false))
        }else{
            ChatFromHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_from, parent, false))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.txtMessage.text = list[position].message
    }

    fun setList(list: List<Chat>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}