

package com.dd.baseui.recyclerview.utils

import com.dd.baseui.recyclerview.item.ItemExpand

/**
 * Item实现该接口来用于记录元素位于集合的层级深度[itemDepth]
 * @see refreshItemDepth 实现接口后还需要手动调用该函数进行初始化赋值
 */
interface ItemDepth {
    /** 当前item在分组中的深度 */
    var itemDepth: Int
}

/**
 * 递归遍历列表为所有实现[ItemDepth]的元素中的字段[ItemDepth.itemDepth]赋值当前位于集合的层级深度
 * @param initDepth  层级深度初始值
 */
fun <T> List<T>.refreshItemDepth(initDepth: Int = 0): List<T> = onEach { item ->
    if (item is ItemDepth) {
        item.itemDepth = initDepth
    }
    if (item is ItemExpand) {
        item.itemSublist?.run { refreshItemDepth(initDepth + 1) }
    }
}