

package com.dd.app.recyclerview.model

import com.dd.baseui.recyclerview.annotaion.ItemOrientation
import com.dd.baseui.recyclerview.annotaion.ItemOrientation.ALL
import com.dd.baseui.recyclerview.item.ItemDrag

data class DragModel(override var itemOrientationDrag: Int = ALL) : ItemDrag {
    fun getText(): String? = if (itemOrientationDrag == ItemOrientation.NONE) "禁用拖拽" else null
}