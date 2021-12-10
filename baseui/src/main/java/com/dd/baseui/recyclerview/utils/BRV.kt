

package com.dd.baseui.recyclerview.utils

object BRV {

    /**
     * 即item的layout布局中的<variable>标签内定义变量名称
     * 示例:
     * ```
     * <variable
     *      name="m"
     *      type="com.dd.baseui.recyclerview.sample.mod.CheckModel" />
     * ```
     * 则应在Application中的onCreate函数内设置:
     * `BindingAdapter.modelId = BR.m`
     */
    var modelId: Int = -1

    /**
     * 防抖动点击事件默认的间隔时间, 单位毫秒
     * @see com.dd.baseui.recyclerview.BindingAdapter.onClick
     */
    var clickThrottle: Long = 500
}