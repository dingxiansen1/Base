package com.dd.base.base

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.dd.base.config.AppConstants
import com.dd.base.utils.SpHelper

open class BaseApp :Application(){

    companion object{
        var isNight :Boolean = false

    }

    override fun onCreate() {
        super.onCreate()

        // 切换情景模式(夜间模式：白天：跟随系统)
        initNightMode()
    }

    private fun initNightMode() {
        isNight=SpHelper.getBoolean(AppConstants.SpKey.FOLLOW_SYSTEM)
        if (isNight)//跟随系统
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        else
            AppCompatDelegate.setDefaultNightMode(
                if (SpHelper.getBoolean(AppConstants.SpKey.NIGHT_MODE)) AppCompatDelegate.MODE_NIGHT_YES//夜间模式
                else AppCompatDelegate.MODE_NIGHT_NO//白天
            )
    }
}