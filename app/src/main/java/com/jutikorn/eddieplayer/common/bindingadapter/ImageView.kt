package com.jutikorn.eddieplayer.common.bindingadapter

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if(url?.isNotEmpty() == true){
        Glide.with(this.context).load(url).into(this)
    }
}