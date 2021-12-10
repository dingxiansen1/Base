package com.dd.app.main

import android.graphics.Color
import cn.onestravel.one.navigation.demo.*
import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.R
import com.dd.app.databinding.ActivityMainBinding
import com.dd.base.base.BaseVBActivity
import com.dd.base.config.AppConstants

@Route(path = AppConstants.Router.Main.A_MAIN)
class MainActivity : BaseVBActivity<ActivityMainBinding>() {

    override fun initView() {

        mViewBinding.oneBottomLayout.setMenu(R.menu.navigation_menu)
        mViewBinding.oneBottomLayout.attachViewPager(supportFragmentManager,mViewBinding.viewPager, listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment(),
            FourFragment(),
            FiveFragment()
        ))
        mViewBinding.oneBottomLayout.isReplace = false
        mViewBinding.oneBottomLayout.setFloatingEnable(true)
        mViewBinding.oneBottomLayout.setTopLineColor(Color.RED)
        mViewBinding.oneBottomLayout.setItemColorStateList(R.drawable.item_check)
        mViewBinding.oneBottomLayout.setMsgCount(0, 32)
        mViewBinding.oneBottomLayout.setMsgCount(2, 1)
        mViewBinding.oneBottomLayout.setMsgCount(1, -1)
        mViewBinding.oneBottomLayout.setOnItemSelectedListener { item, position ->
            false
        }

    }
}