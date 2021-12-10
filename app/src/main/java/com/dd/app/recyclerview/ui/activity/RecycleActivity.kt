package com.dd.app.recyclerview.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.R
import com.dd.app.databinding.RecyclerActivityBinding
import com.dd.base.base.BaseVDActivity
import com.dd.base.config.AppConstants

@Route(path = AppConstants.Router.Main.A_RECYCLER)
class RecycleActivity :BaseVDActivity<RecyclerActivityBinding>(R.layout.recycler_activity){
    override fun initView() {
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav)
        binding.toolbar.setupWithNavController(
            navController,
            AppBarConfiguration(binding.navView.menu, binding.drawer)
        )
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.toolbar.subtitle =
                (destination as FragmentNavigator.Destination).className.substringAfterLast('.')
        }

        binding.navView.setupWithNavController(navController)
    }
}
