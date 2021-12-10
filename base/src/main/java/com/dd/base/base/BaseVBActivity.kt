package com.dd.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.dd.base.ActivityManage
import com.dd.base.R
import com.dd.base.config.AppConstants
import com.dd.base.utils.SpHelper
import com.dd.base.utils.darkMode
import com.dd.base.utils.statusBarColorRes
import java.lang.reflect.ParameterizedType

abstract class BaseVBActivity<VB: ViewBinding> : AppCompatActivity() {

    lateinit var mViewBinding: VB

    private var mActivityProvider: ViewModelProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initViewBinding())
        this.statusBarColorRes(R.color.background)
        this.darkMode()
        ActivityManage.addActivity(this)
        initView()
    }

    abstract fun initView()

    /**
     * 创建 ViewBinding
     */
    fun initViewBinding(): View {
        //利用反射 根据泛型得到 ViewBinding
        val superClass = javaClass.genericSuperclass
        val aClass = (superClass as ParameterizedType).actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mViewBinding =  method.invoke(null,layoutInflater) as VB
        return mViewBinding.root
    }


    protected open fun <T : ViewModel?> getViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)
        }
        return mActivityProvider!![modelClass]
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManage.removeActivity(this)
    }

    fun updataNightModel(){
        val isNight= !SpHelper.getBoolean(AppConstants.SpKey.NIGHT_MODE)
        SpHelper.put(AppConstants.SpKey.NIGHT_MODE,isNight)
        AppCompatDelegate.setDefaultNightMode(
            if (isNight) AppCompatDelegate.MODE_NIGHT_YES//夜间模式
            else AppCompatDelegate.MODE_NIGHT_NO//白天
        )
        this.statusBarColorRes(R.color.background)
        this.darkMode(!isNight)
    }
}