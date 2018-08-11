package com.jutikorn.eddieplayer.common.view

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView


class AppViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindObject(obj: Any?) {
        obj?.let { binding.setVariable(com.jutikorn.eddieplayer.BR.obj, obj) }
    }

    fun bindHandler(handler: Any?) {
        handler?.let { binding.setVariable(com.jutikorn.eddieplayer.BR.handler, handler) }
    }

    fun executePendingBindings(){
        binding.executePendingBindings()
    }
}