package com.dd.base.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.alibaba.android.arouter.launcher.ARouter
import com.dd.base.config.AppConstants
import com.dd.base.utils.SpHelper
import com.dd.base.BuildConfig
import com.tencent.mmkv.MMKV

open class BaseApp :Application(){

    override fun onCreate() {
        super.onCreate()

        //阿里路由
        if (BuildConfig.DEBUG) {  //debug模式开启日志
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        //MMKV初始化
        MMKV.initialize(this)

        // 切换情景模式(夜间模式：白天：跟随系统)
        initNightMode()
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

    private fun initNightMode() {
        if (SpHelper.getBoolean(AppConstants.SpKey.FOLLOW_SYSTEM))//跟随系统
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        else
            AppCompatDelegate.setDefaultNightMode(
                if (SpHelper.getBoolean(AppConstants.SpKey.NIGHT_MODE)) AppCompatDelegate.MODE_NIGHT_YES//夜间模式
                else AppCompatDelegate.MODE_NIGHT_NO//白天
            )
    }
}