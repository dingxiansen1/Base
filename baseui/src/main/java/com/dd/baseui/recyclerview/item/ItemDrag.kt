

package com.dd.baseui.recyclerview.item

import com.dd.baseui.recyclerview.annotaion.ItemOrientation

/**
 * 可拖拽
 */
interface ItemDrag {
    /**
     * 拖拽方向
     * @see ItemOrientation
     */
    var itemOrientationDrag: Int
}