package com.jutikorn.eddieplayer.common.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): AppViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater, viewType, parent, false)
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder,
                                  position: Int) {
        getObjForPosition(position)?.let {
            holder.bindObject(it)
        }

        getHandlerForPosition(position)?.let {
            holder.bindHandler(it)
        }
        holder.executePendingBindings()
    }

    override fun getItemViewType(position: Int): Int = getLayoutIdForPosition(position)

    protected abstract fun getObjForPosition(position: Int): Any?

    protected abstract fun getHandlerForPosition(position: Int): Any?

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    abstract fun <T> setValues(list: List<T>)
}