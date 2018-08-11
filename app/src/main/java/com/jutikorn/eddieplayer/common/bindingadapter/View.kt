package com.jutikorn.eddieplayer.common.bindingadapter

import android.databinding.BindingAdapter
import android.view.View


@BindingAdapter("isVisible")
fun View.setVisible(isVisible: Boolean) {
    if (isVisible) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}