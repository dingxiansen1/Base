package com.dd.base.toast.utils

import com.dd.base.toast.expand.dp
import com.dd.base.toast.expand.sp

class ToastUtils {
    companion object{
        @JvmStatic
        fun toDip(value:Int):Int{
            return value.dp
        }


        @JvmStatic
        fun toSp(value:Int):Int{
            return value.sp
        }


        @JvmStatic
        fun toDip(value:Float):Float{
            return value.dp
        }


        @JvmStatic
        fun toSp(value:Float):Float{
            return value.sp
        }
    }
}