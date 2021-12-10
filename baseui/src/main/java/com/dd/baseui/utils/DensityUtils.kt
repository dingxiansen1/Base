package com.dd.baseui.utils

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue

object DensityUtils {

    /**
     * dp转换为px
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dpToPx(context: Context, dpValue: Float): Int {//dp转换为px
        val scale = context.resources.displayMetrics.density//获得当前屏幕密度
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * px转换为dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    fun pxToDp(context: Context, pxValue: Float): Int {//
        val scale = context.resources.displayMetrics.density//获得当前屏幕密度
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * dp转换为px
     *
     * @param resources
     * @param dpValue
     * @return
     */
    fun dpToPx(resources: Resources, dpValue: Float): Int {
        val scale = resources.displayMetrics.density//获得当前屏幕密度
        return (dpValue * scale + 0.5f).toInt()
    }


    /**
     * px转换为dp
     *
     * @param resources
     * @param pxValue
     * @return
     */
    fun pxToDp(resources: Resources, pxValue: Float): Int {//
        val scale = resources.displayMetrics.density//获得当前屏幕密度
        return (pxValue / scale + 0.5f).toInt()
    }


    /**
     * sp转换为px
     *
     * @param resources
     * @param spValue
     * @return
     */
    fun spToPx(resources: Resources, spValue: Float): Int {
        val scale = resources.displayMetrics.scaledDensity//获得当前屏幕密度
        return (spValue * scale + 0.5f).toInt()
    }


    /**
     * px转换为sp
     *
     * @param resources
     * @param pxValue
     * @return
     */
    fun pxToSp(resources: Resources, pxValue: Float): Int {//
        val scale = resources.displayMetrics.scaledDensity//获得当前屏幕密度
        return (pxValue / scale + 0.5f).toInt()
    }

    @JvmStatic
    fun Float.dp2px(context: Context) = dp2px(context, this)

    @JvmStatic
    fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.resources.displayMetrics).toInt()
    }

    @JvmStatic
    fun Int.px2dp(context: Context) = px2dp(context, this)

    @JvmStatic
    fun px2dp(context: Context, pxVal: Int): Float {
        return pxVal / context.resources.displayMetrics.density
    }

    @JvmStatic
    fun Float.sp2px(context: Context) = sp2px(context, this)


    @JvmStatic
    fun sp2px(context: Context, spVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.resources.displayMetrics).toInt()
    }

    @JvmStatic
    fun Int.px2sp(context: Context) = px2sp(context, this)

    @JvmStatic
    fun px2sp(context: Context, pxVal: Int): Float {
        return pxVal / context.resources.displayMetrics.scaledDensity
    }
}
