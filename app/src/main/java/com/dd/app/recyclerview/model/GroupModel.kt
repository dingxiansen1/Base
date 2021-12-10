

package com.dd.app.recyclerview.model

import androidx.databinding.BaseObservable
import com.dd.baseui.recyclerview.item.ItemExpand
import com.dd.baseui.recyclerview.item.ItemHover
import com.dd.baseui.recyclerview.item.ItemPosition
import com.dd.app.R

class GroupModel : ItemExpand, ItemHover, ItemPosition,
    BaseObservable() {

    override var itemGroupPosition: Int = 0
    override var itemExpand: Boolean = false
        set(value) {
            field = value
            notifyChange()
        }

    // 这种代理方式是为了避免Gson等框架解析Kotlin会覆盖默认值问题: https://liangjingkanji.github.io/BRV/group.html#_2
    override var itemSublist: List<Any?>?
        get() = finalList
        set(value) {
            finalList = value as List<Model>
        }

    var finalList: List<Model> = listOf(Model(), Model(), Model(), Model())

    override var itemHover: Boolean = true
    override var itemPosition: Int = 0

    val title get() = "分组 [ $itemGroupPosition ]"

    val expandIcon get() = if (itemExpand) R.drawable.ic_arrow_expand else R.drawable.ic_arrow_collapse

}