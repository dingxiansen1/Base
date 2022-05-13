package com.dd.base.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dd.base.ActivityManage
import com.dd.base.R
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
        ActivityManage.addActivity(this)
        this.statusBarColorRes(R.color.background)
        if (BaseApp.isNight){
            this.darkMode(!BaseApp.isNight)
        }
        initView()
    }

    protected abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        ActivityManage.removeActivity(this)
    }
    protected fun launch(block: () -> Unit) {
        lifecycleScope.launch(Dispatchers.Default) {
            block()
        }
    }

    protected fun launchIO(block: () -> Unit) {
        lifecycleScope.launch(Dispatchers.IO) {
            block()
        }
    }

    protected fun launchMain(block: () -> Unit) {
        lifecycleScope.launch(Dispatchers.Main) {
            block()
        }
    }
}