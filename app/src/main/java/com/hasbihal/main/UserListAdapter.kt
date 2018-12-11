package com.hasbihal.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hasbihal.R
import com.hasbihal.data.model.User
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.MainViewHolder>() {

    private val list: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun updateUsers(products: List<User>) {
        this.list.clear()
        this.list.addAll(products)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position])
    }


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            itemView.txtUserName.text    = user.name
            itemView.txtDescription.text = user.summary

            val options = RequestOptions()
                    .placeholder(R.drawable.ic_profile_24dp)
                    .error(R.drawable.ic_profile_24dp)

            Glide.with(itemView)
                    .load(user.photoUrl)
                    .apply(options)
                    .into(itemView.imgProfile)

        }
    }
}

