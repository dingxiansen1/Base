package com.dd.base.ext

import android.view.View
import android.view.ViewGroup

/**
 * 扩展方法：设置点击事件，防止快速点击
 */
fun View.setSingleClick(ignoreTime: Int = 500, onclick: (View) -> Unit) {
    var mLastClickMills = 0L
    setOnClickListener {
        val currentTimeMillis = System.currentTimeMillis()
        if (currentTimeMillis - mLastClickMills >= ignoreTime) {
            mLastClickMills = currentTimeMillis
            onclick.invoke(this)
        }
    }
}

fun View.showIf(isShow: Boolean) {
    if (isShow) {
        show()
    } else {
        hide()
    }
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

/**
 * 改变View宽高
 * */
fun View.changeSize(width: Int, height: Int): View {
    this.layoutParams?.let {
        it.width = width
        it.height = height
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View宽
 **/
infix fun View.width(width: Int): View {
    this.layoutParams?.let {
        it.width = width
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View高
 * */
infix fun View.height(height: Int): View {
    this.layoutParams?.let {
        it.height = height
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View上外间距
 * */
infix fun View.marginTop(distance: Int): View {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let {
        it.topMargin = distance
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View左外间距
 * */
infix fun View.marginStart(distance: Int): View {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let {
        it.marginStart = distance
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View右外间距
 * */
infix fun View.marginEnd(distance: Int): View {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let {
        it.marginEnd = distance
        this.layoutParams = it
    }
    return this
}

/**
 * 改变View下外间距
 * */
infix fun View.marginBottom(distance: Int): View {
    (this.layoutParams as? ViewGroup.MarginLayoutParams)?.let {
        it.bottomMargin = distance
        this.layoutParams = it
    }
    return this
}

