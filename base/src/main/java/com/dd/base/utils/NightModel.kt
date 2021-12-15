package com.dd.base.utils

import androidx.appcompat.app.AppCompatDelegate
import com.dd.base.base.BaseApp
import com.dd.base.config.AppConstants

class NightModel private constructor() {

    companion object{
        fun updataNightModel(){
            BaseApp.isNight = !BaseApp.isNight
            SpHelper.put(AppConstants.SpKey.NIGHT_MODE, BaseApp.isNight)
            AppCompatDelegate.setDefaultNightMode(
                if (BaseApp.isNight) AppCompatDelegate.MODE_NIGHT_YES//夜间模式
                else AppCompatDelegate.MODE_NIGHT_NO//白天
            )
        }
    }

}