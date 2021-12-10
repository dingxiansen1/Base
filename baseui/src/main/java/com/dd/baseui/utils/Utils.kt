package com.dd.baseui.utils

import android.view.View
import android.view.ViewGroup

object Utils {

    fun getViewWidth(view: View): Int {
        view.measure(0, 0)
        return view.measuredWidth
    }

    /**
     * 移除父布局中的子布局
     *
     * @param view
     */
    fun removeFromParent(view: View) {
        if (view.parent != null) {
            (view.parent as ViewGroup).removeView(view)
        }
    }
}