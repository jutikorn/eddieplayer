package com.jutikorn.eddieplayer.common.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.RecyclerView

class SeparatorItemDecoration : RecyclerView.ItemDecoration() {

    val paint = Paint().apply {
        this.color = Color.GRAY
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)

        parent?.let {
            val childCount = parent.childCount
            for (i in 0 until childCount) {
                val child = parent.getChildAt(i)
                c?.drawLine(16.toPx.toFloat(), child.bottom.toFloat(), child.right - 16.toPx.toFloat(), child.bottom.toFloat() + 1.toPx.toFloat(), paint)
            }
        }
    }
}