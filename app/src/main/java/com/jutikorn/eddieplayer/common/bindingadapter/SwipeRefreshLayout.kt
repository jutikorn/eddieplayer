package com.jutikorn.eddieplayer.common.bindingadapter

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout


@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.isRefreshing(refresh: Boolean) {
    this.isRefreshing = refresh
}

@BindingAdapter("onRefresh")
fun SwipeRefreshLayout.onRefresh(refresh: SwipeRefreshLayout.OnRefreshListener) {
    this.setOnRefreshListener(refresh)
}