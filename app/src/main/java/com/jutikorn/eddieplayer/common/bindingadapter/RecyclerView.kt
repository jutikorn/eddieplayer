package com.jutikorn.eddieplayer.common.bindingadapter

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.jutikorn.eddieplayer.common.view.BaseRecyclerViewAdapter


@BindingAdapter(value = ["lifeCyclerOwner", "livedata"], requireAll = true)
fun <T : Any> RecyclerView.observeLiveData(lifeCyclerOwner: LifecycleOwner, liveData: LiveData<List<T>>) {
    liveData.observe(lifeCyclerOwner, Observer {
        val adapter = this.adapter
        if (adapter is BaseRecyclerViewAdapter) {
            it?.let { adapter.setValues(it) }
        }
    })
}

@BindingAdapter("hasFixSize")
fun RecyclerView.hasFixSize(fixSize: Boolean){
    this.setHasFixedSize(fixSize)
}

@BindingAdapter("decoration")
fun <T : RecyclerView.ItemDecoration> RecyclerView.setItemDecoration(decor: T) {
    this.addItemDecoration(decor)
}

@BindingAdapter("adapter")
fun <T : RecyclerView.Adapter<VH>, VH : RecyclerView.ViewHolder> RecyclerView.adapter(adapter: T) {
    this.adapter = adapter
}