package com.hasbihal.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(url: String){
    Glide.with(this.context)
            .load(url)
            .into(this)
}

fun ImageView.loadWithRounded(url: String){
    Glide.with(this.context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}
