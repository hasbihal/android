package com.hasbihal.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasbihal.data.model.UserEntity
import com.hasbihal.extension.load
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserListAdapter(private val context: Context,
                      private val data: List<UserEntity>,
                      private val layoutID: Int) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(layoutID, parent, false))
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.txtDescription.text = data[position].descripton
        holder.imgProfile.load(data[position].photoUrl)
    }


}

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgProfile = view.imgProfile
    val txtDescription = view.txtDescription
}