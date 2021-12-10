package com.dd.baseui.flowLayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import java.lang.RuntimeException
/**
 * @describe 流布局
 */

/**
 * @author zwl
 * @describe 流布局
 * @date on 2020/12/31
 */
open class FlowListView : FlowLayout, FlowAdapter.OnDataChangedListener {
    @JvmField
    protected var flowAdapter: FlowAdapter<*>? = null

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    fun setAdapter(tagAdapter: FlowAdapter<*>?) {
        flowAdapter = tagAdapter
        flowAdapter!!.setOnDataChangedListener(this)
        updateView()
    }

    public override fun onChanged() {
        updateView()
    }

    private fun updateView() {
        removeAllViews()
        if (null == flowAdapter) {
            throw RuntimeException("adapter cannot be empty")
        }
        val count: Int = flowAdapter!!.count
        for (i in 0 until count) {
            val tagView: View = flowAdapter!!.getView(this, flowAdapter!!.getItem(i), i)!!
            tagView.setTag(flowAdapter!!.getItem(i))
            flowAdapter!!.initView(tagView, flowAdapter!!.getItem(i), i)
            addView(tagView)
        }
    }
}