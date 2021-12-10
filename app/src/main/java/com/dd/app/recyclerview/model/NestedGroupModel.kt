

package com.dd.app.recyclerview.model

import androidx.databinding.BaseObservable
import com.dd.baseui.recyclerview.item.ItemExpand
import com.dd.app.R

class NestedGroupModel : ItemExpand, BaseObservable() {

    override var itemGroupPosition: Int = 0
    override var itemExpand: Boolean = false
        set(value) {
            field = value
            notifyChange()
        }
    override var itemSublist: List<Any?>? = listOf(Model(), Model(), Model(), Model())
    val title get() = "嵌套分组 [ $itemGroupPosition ]"
    val expandIcon get() = if (itemExpand) R.drawable.ic_arrow_nested_expand else R.drawable.ic_arrow_nested_collapse
}