package com.hasbihal.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasbihal.R
import kotlinx.android.synthetic.main.item_chat_to.view.*
import timber.log.Timber

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val MESSAGE_FROM_ME = 99
    private val MESSAGE_FROM_TO = 98

    private var list = mutableListOf<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            MESSAGE_FROM_TO -> ChatToHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_to, parent, false))
            MESSAGE_FROM_ME -> ChatFromHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_from, parent, false))
            else -> {
                Timber.e("undefined view type")
                ChatToHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat_to, parent, false))
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(list[position].isMeSender){
            MESSAGE_FROM_ME
        }else{
            MESSAGE_FROM_TO
        }
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