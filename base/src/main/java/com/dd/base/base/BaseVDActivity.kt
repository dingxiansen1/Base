package com.dd.base.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.base.R
import com.dd.base.config.AppConstants
import com.dd.base.utils.SpHelper
import com.dd.base.utils.darkMode
import com.dd.base.utils.statusBarColorRes

abstract class BaseVDActivity <B : ViewDataBinding>(@LayoutRes contentLayoutId: Int = 0) :
    AppCompatActivity(contentLayoutId){
    lateinit var binding: B

    private var mActivityProvider: ViewModelProvider? = null

    override fun setContentView(layoutResId: Int) {
        val rootView = layoutInflater.inflate(layoutResId, null)
        setContentView(rootView)
        binding = DataBindingUtil.bind(rootView)!!
        binding.lifecycleOwner = this
        this.statusBarColorRes(R.color.background)
        this.darkMode()
        initView()
    }

    override fun onRestart() {
        super.onRestart()
    }

    protected abstract fun initView()


    protected open fun <T : ViewModel?> getViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this)
        }
        return mActivityProvider!![modelClass]
    }
    protected open fun <T : ViewModel?> getAndroidViewModel(modelClass: Class<T>): T {
        if (mActivityProvider == null) {
            mActivityProvider = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
        }
        return mActivityProvider!!.get(modelClass)
    }

    fun updataNightModel(){
        val isNight= !SpHelper.getBoolean(AppConstants.SpKey.NIGHT_MODE)
        SpHelper.put(AppConstants.SpKey.NIGHT_MODE,isNight)
        AppCompatDelegate.setDefaultNightMode(
            if (isNight) AppCompatDelegate.MODE_NIGHT_YES//夜间模式
            else AppCompatDelegate.MODE_NIGHT_NO//白天
        )
    }
}