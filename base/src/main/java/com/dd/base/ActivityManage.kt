package com.dd.base

import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

/*
* Activity栈管理器
* */
object ActivityManage {

    private val activities = ArrayList<AppCompatActivity>()

    fun addActivity(activity: AppCompatActivity) {
        activities.add(activity)
    }

    fun removeActivity(activity: AppCompatActivity) {
        activities.remove(activity)
    }

    fun finishAllActivities() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    val activityByCurrentlyRun: AppCompatActivity?
        get() = if (activities.size <= 0) {
            null
        } else activities[activities.size - 1]

    /**
     * 判断指定Activity是否存在
     */
    fun isExist(activityClass: Class<*>): Boolean {
        var result = false
        for (item in activities) {
            if (null != item && item.javaClass == activityClass) {
                result = true
                break
            }
        }
        return result
    }

    fun getByClass(activity: Class<*>): AppCompatActivity? {
        for (item in activities) {
            if (null != item && item.javaClass == activity) {
                return item
            }
        }
        return null
    }
}
