

package com.dd.baseui.recyclerview.item

/**
 * 可粘性头部的条目
 */
interface ItemHover {
    /**
     * 是否启用粘性头部
     * [com.dd.baseui.recyclerview.utils.RecyclerUtilsKt.linear]
     * [com.dd.baseui.recyclerview.utils.RecyclerUtilsKt.grid]
     * [com.dd.baseui.recyclerview.utils.RecyclerUtilsKt.staggered]
     */
    var itemHover: Boolean
}