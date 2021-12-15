package com.dd.base.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dd.base.R
import com.dd.base.config.AppConstants
import com.dd.base.utils.SpHelper
import com.dd.base.utils.darkMode
import com.dd.base.utils.statusBarColorRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        if (BaseApp.isNight){
            this.darkMode(!BaseApp.isNight)
        }
        initView()
    }

    protected abstract fun initView()

    fun launch(block:()->Unit){
        lifecycleScope.launch(Dispatchers.IO) {
            block.invoke()
        }
    }

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

}