

package com.dd.baseui.recyclerview.utils

import android.view.View
import android.view.ViewGroup
import com.dd.baseui.recyclerview.PageRefreshLayout


/**
 * PageRefreshLayout 包裹当前 view
 *
 * @receiver View
 * @param loadMoreEnabled Boolean 启用上拉加载
 * @param stateEnabled Boolean 启用缺省页
 */
fun View.page(
    loadMoreEnabled: Boolean = true,
    stateEnabled: Boolean = true
): PageRefreshLayout {

    val pageRefreshLayout = PageRefreshLayout(context)

    val parent = parent as ViewGroup
    pageRefreshLayout.id = id
    val index = parent.indexOfChild(this)
    val layoutParams = layoutParams

    parent.removeView(this)
    pageRefreshLayout.setRefreshContent(this@page)
    parent.addView(pageRefreshLayout, index, layoutParams)


    pageRefreshLayout.apply {
        setEnableLoadMore(loadMoreEnabled)
        this.stateEnabled = stateEnabled
        initialize()
    }

    return pageRefreshLayout
}


