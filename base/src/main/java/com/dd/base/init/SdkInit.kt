package com.dd.base.init

import android.content.Context
import com.tencent.mmkv.MMKV

object SdkInit {

    fun init(context: Context){
        //MMKV初始化
        MMKV.initialize(context)
    }
}