

package com.dd.baseui.recyclerview.item

import com.dd.baseui.recyclerview.annotaion.ItemOrientation

/**
 * 可侧滑的条目
 */
interface ItemSwipe {

    /**
     * 侧滑方向
     * @see ItemOrientation
     */
    var itemOrientationSwipe: Int
}