package com.dd.base.route

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

/**
* @Date 2020/10/23
 * @Description
 */
object RouteCenter {
    /*
    *@path 路由地址
    *@bundle 传参
    * */
    fun navigate(path: String, bundle: Bundle? = null): Any? {
        val build = ARouter.getInstance().build(path)
        return if (bundle == null) build.navigation() else build.with(bundle).navigation()
    }

    /*
    *@context Activity
    *@path 路由地址
    *@bundle 传参
    *@requestCode 回调序号
    * 需要回调使用这个，比如相册选择图片等！！、
    * */
    fun navigate(context:Activity,path: String, bundle: Bundle? = null,requestCode:Int=-1): Any {
        val build = ARouter.getInstance().build(path)
        return if (bundle == null) build.navigation(context,requestCode) else build.with(bundle).navigation(context,requestCode)
    }

}
