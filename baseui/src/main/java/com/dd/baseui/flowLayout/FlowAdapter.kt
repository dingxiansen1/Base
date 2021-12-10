package com.dd.baseui.flowLayout

import android.view.View
import android.view.ViewGroup
import java.util.ArrayList


/**
 * @author zwl
 * @describe 流布局适配器
 * @date on 2020/12/31
 */
abstract class FlowAdapter<T> {
    private var onDataChangedListener: OnDataChangedListener? = null
    private var data: MutableList<T>? = null

    /**
     * 子View创建
     *
     * @param parent
     * @param item
     * @param position
     * @return
     */
    abstract fun getView(parent: ViewGroup?, item: Any?, position: Int): View?

    /**
     * 初始化View
     *
     * @param view
     * @param item
     * @param position
     * @return
     */
    abstract fun initView(view: View?, item: Any?, position: Int)

    /**
     * 折叠View 默认不设置
     *
     * @return
     */
    fun foldView(): View? {
        return null
    }

    /**
     * 数据的数量
     *
     * @return
     */
    val count: Int
        get() = if (data == null) 0 else data!!.size

    /**
     * 获取数据
     *
     * @return
     */
    fun getData(): List<T>? {
        return data
    }

    /**
     * 设置新数据
     *
     * @param data
     */
    fun setNewData(data: MutableList<T>?) {
        this.data = data
        notifyDataChanged()
    }
    fun clearData() {
        this.data = null
        notifyDataChanged()
    }
    /**
     * 添加数据
     *
     * @param data
     */
    fun addData(data: List<T>?) {
        if (this.data == null) {
            this.data = ArrayList()
        }
        this.data!!.addAll(data!!)
        notifyDataChanged()
    }

    /**
     * 添加数据
     *
     * @param index
     * @param data
     */
    fun addData(index: Int, data: List<T>?) {
        if (this.data == null) {
            this.data = ArrayList()
        }
        this.data!!.addAll(index, data!!)
        notifyDataChanged()
    }

    /**
     * 添加数据
     *
     * @param data
     */
    fun addData(data: T) {
        if (this.data == null) {
            this.data = ArrayList()
        }
        this.data!!.add(data)
        notifyDataChanged()
    }

    /**
     * 获取指定位置的数据
     *
     * @param position
     * @return
     */
    fun getItem(position: Int): T? {
        return if (data != null && position >= 0 && position < data!!.size) {
            data!![position]
        } else null
    }

    /**
     * 刷新数据
     */
    fun notifyDataChanged() {
        if (onDataChangedListener != null) {
            onDataChangedListener!!.onChanged()
        }
    }

    internal fun setOnDataChangedListener(listener: OnDataChangedListener) {
        onDataChangedListener = listener
    }

    internal interface OnDataChangedListener {
        fun onChanged()
    }
}
