

package com.dd.app.recyclerview.vm

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun ImageView.bindImageRes(@DrawableRes drawable: Int) {
    setImageResource(drawable)
}