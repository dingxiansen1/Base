package com.dd.base.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass
/**
 * 启动一个Activity
 * */
inline fun <reified T : Activity> Activity.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this, clazz.java))
}
inline fun <reified T : Activity> Fragment.startActivity(clazz: KClass<T>) {
    this.startActivity(Intent(this.activity, clazz.java))
}