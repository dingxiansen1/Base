package com.dd.baseui.flowLayout

import android.content.Context
import android.util.AttributeSet
import kotlin.jvm.JvmOverloads
import android.view.LayoutInflater
import android.view.View
import com.dd.baseui.R
import com.dd.baseui.utils.Utils

/**
 * @author zwl
 * @describe 折叠
 * @date on 2021/8/7
 */
class SearchHistoryView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FlowListView(
    context!!, attrs, defStyleAttr
) {
    private val upFoldView: View
    private val downFoldView: View


    init {
        upFoldView = LayoutInflater.from(context).inflate(R.layout.view_item_fold_up, null)
        downFoldView = LayoutInflater.from(context).inflate(R.layout.view_item_fold_down, null)
        upFoldView.setOnClickListener { v: View? ->
            mFold = false
            flowAdapter!!.notifyDataChanged()
        }
        downFoldView.setOnClickListener { v: View? ->
            mFold = true
            flowAdapter!!.notifyDataChanged()
        }
        setOnFoldChangedListener(object : OnFoldChangedListener {
            override fun onFoldChange(canFold: Boolean, fold: Boolean, index: Int, surplusWidth: Int) {
                if (canFold) {
                    Utils.removeFromParent(downFoldView)
                    addView(downFoldView)
                    if (fold) {
                        Utils.removeFromParent(upFoldView)
                        val upIndex = index(index, surplusWidth)
                        addView(upFoldView, upIndex)
                    } else {
                        Utils.removeFromParent(downFoldView)
                        addView(downFoldView)
                    }
                }
            }
        })
    }

    private fun index(index: Int, surplusWidth: Int): Int {
        var upIndex = index
        var upWidth: Int = Utils.getViewWidth(upFoldView)
        //当剩余空间大于等于展开View宽度直接加入index+1
        if (surplusWidth >= upWidth) {
            upIndex = index + 1
        } else { //找到对应的位置
            for (i in index downTo 0) {
                val view = getChildAt(index)
                val viewWidth: Int = Utils.getViewWidth(view)
                upWidth -= viewWidth
                if (upWidth <= 0) {
                    upIndex = i
                    break
                }
            }
        }
        return upIndex
    }

}