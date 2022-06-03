package com.odsstudio.contactsbook.decorators

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class IconItemDecorator(val startOffset: Int, val endOffset: Int, val betwenOffset: Int): RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {

        val iconList = parent.layoutManager?.itemCount

        if (iconList != null) {
            when(itemPosition) {
                0 -> {
                    outRect.offset(0, 16)
                    outRect.left = 20
                    outRect.right = 8
                    Log.d("itempos", "$itemPosition - 0")
                }
                iconList - 1 -> {
                    outRect.offset(0, 16)
                    outRect.left = 8
                    outRect.right = 20
                    Log.d("itempos", "$itemPosition - last")
                }
                else -> {
                    outRect.offset(betwenOffset / 2, 16)
                    Log.d("itempos", "$itemPosition - else")
                }
            }
        }
    }
}