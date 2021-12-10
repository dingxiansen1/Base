package cn.onestravel.one.navigation.demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.dd.app.R
import com.dd.app.databinding.Fragment1Binding
import com.dd.app.databinding.SnackbarTaostBinding
import com.dd.base.base.BaseVBFragment
import com.dd.base.config.AppConstants
import com.dd.base.route.RouteCenter
import com.dd.base.utils.SpHelper
import com.dd.baseui.SnackBarView
import com.google.android.material.snackbar.Snackbar


class FirstFragment : BaseVBFragment<Fragment1Binding>() {
    override fun initView() {
        Log.e("初始化","完成")
        mViewBinding!!.button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name","申请权限")
            RouteCenter.navigate(AppConstants.Router.Main.A_TEST,bundle)
        }
        mViewBinding!!.button2.setOnClickListener {
            RouteCenter.navigate(AppConstants.Router.Main.A_DIALOG)
        }
        mViewBinding!!.button3.setOnClickListener {
            RouteCenter.navigate(AppConstants.Router.Main.A_RECYCLER)
        }
        mViewBinding!!.button4.setOnClickListener {
            RouteCenter.navigate(AppConstants.Router.Main.A_TOAST)
        }
        mViewBinding!!.button5.setOnClickListener {
            RouteCenter.navigate(AppConstants.Router.Main.A_NIGHT)
        }
    }
}
