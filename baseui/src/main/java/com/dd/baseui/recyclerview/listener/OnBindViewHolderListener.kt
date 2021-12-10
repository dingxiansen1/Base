

package com.dd.baseui.recyclerview.listener

import androidx.recyclerview.widget.RecyclerView
import com.dd.baseui.recyclerview.BindingAdapter

interface OnBindViewHolderListener {
    fun onBindViewHolder(rv: RecyclerView,
                         adapter: BindingAdapter,
                         holder: BindingAdapter.BindingViewHolder,
                         position: Int)
}