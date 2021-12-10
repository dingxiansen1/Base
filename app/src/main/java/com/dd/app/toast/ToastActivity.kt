package com.dd.app.toast

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.BR
import com.dd.app.R
import com.dd.app.databinding.ToastActivityBinding
import com.dd.base.base.BaseVDActivity
import com.dd.base.config.AppConstants
import com.dd.base.route.RouteCenter
import com.dd.base.toast.ToastX
import com.dd.base.toast.expand.dp

@Route(path = AppConstants.Router.Main.A_TOAST)
class ToastActivity : BaseVDActivity<ToastActivityBinding>(R.layout.toast_activity) {

    var title = "您有一条新消息"
    var desc = "新消息内容，新消息内容新消息内容新消息内容新消息内容新消息内容新消息内容"

    override fun initView() {
        binding.btn1.setOnClickListener {
            ToastX.with(this)
                .text("我是在顶部的")
                .backgroundColor(R.color.teal_200)
                .animationMode(ToastX.ANIM_MODEL_SLIDE)
                .textColor(R.color.color_FFFFFF)
                .position(ToastX.POSITION_TOP)
                .textGravity(Gravity.CENTER)
                .duration(1000)
                .textSize(14f)
                .padding(10.dp, 10.dp)
                .margin(15.dp, 15.dp)
                .height(40.dp)
                .width(100.dp)
                .radius(10f.dp)
                .offset(40.dp)
                .show()
        }
        /*
        普通Toast用法
        ToastX.with(this)
         .text("我是在顶部的") //文字
         .backgroundColor(R.color.toast_background_color_config3_succeed) //背景
         .animationMode(ToastX.ANIM_MODEL_SLIDE) //动画模式 弹出或者渐变
         .textColor(R.color.color_FFFFFF) //文字颜色
         .position(ToastX.POSITION_TOP) //显示的位置 顶部或者底部
         .textGravity(Gravity.CENTER) //文字的位置
         .duration(1000) //显示的时间 单位ms
         .textSize(14f) //文字大小 单位sp
         .padding(10.dp, 10.dp) //左右内边距
         .margin(15.dp, 15.dp) //左右外边距
         .height(40.dp) //整个的高度
         .width(100.dp) //整个的宽度
         .radius(10f.dp) //圆角半径
         .offset(10.dp) //距离顶部或者底部的偏移量
         .show() //显示

        自定义布局用法
        ToastX.with(this)
              .customizeView(this,R.layout.message_view){
                    点击事件
                }
             .animationMode(ToastX.ANIM_MODEL_SLIDE) //动画模式 弹出或者渐变
             .position(ToastX.POSITION_TOP) //显示的位置 顶部或者底部
             .duration(1000) //显示的时间 单位ms
             .margin(15.dp, 15.dp) //左右外边距
             .offset(10.dp) //距离顶部或者底部的偏移量
             .show() //显示


        * */
        binding.btn2.setOnClickListener {
            ToastX.with(this)
                .text("我是在底部的")
                .margin(15.dp, 15.dp)
                .backgroundColor(R.color.teal_200)
                .textColor(R.color.color_FFFFFF)
                .position(ToastX.POSITION_BOTTOM)
                .offset(10.dp)
                .show()
        }
        binding.btn3.setOnClickListener {
            ToastX.with(this)
                .text("网络已断开，请检查网络")
                .margin(15.dp, 15.dp)
                .backgroundColor(R.color.red)
                .position(ToastX.POSITION_TOP)
                .show()
        }
        binding.btn4.setOnClickListener {
            ToastX.with(this)
                .text("数据正在上传中...")
                .margin(15.dp, 15.dp)
                .position(ToastX.POSITION_TOP)
                .backgroundColor(R.color.teal_200)
                .show()
        }
        binding.btn5.setOnClickListener {
            ToastX.with(this)
                .text("数据提交成功")
                .margin(15.dp, 15.dp)
                .position(ToastX.POSITION_TOP)
                .backgroundColor(R.color.teal_200)
                .show()
        }
        binding.btn6.setOnClickListener {
            ToastX.with(this)
                .text("数据提交失败，请重试")
                .margin(15.dp, 15.dp)
                .position(ToastX.POSITION_TOP)
                .backgroundColor(R.color.teal_200)
                .show()
        }
        binding.btn7.setOnClickListener {
            ToastX.with(this)
                .customizeView(this,R.layout.message_view){
                    RouteCenter.navigate(AppConstants.Router.Main.A_DIALOG)
                }
                .position(ToastX.POSITION_TOP)
                .margin(15.dp, 15.dp)
                .show()
        }
        binding.btn8.setOnClickListener {
            ToastX.with(this)
                .customizeView(this,R.layout.message_view){
                    title="变了哦"
                    desc="变了哦变了哦变了哦变了哦变了哦变了哦变了哦变了哦变了哦变了哦变了哦变了哦"
                }
                .position(ToastX.POSITION_BOTTOM)
                .offset(10.dp)
                .margin(15.dp, 15.dp)
                .show()
        }
        binding.btn9.setOnClickListener {
          ToastX.with(this)
                .customizeView(this,R.layout.message_view){

                }
              .duration(ToastX.DURATION_INDEFINITE)
                .position(ToastX.POSITION_TOP)
                .margin(15.dp, 15.dp)
                .show()
        }
    }
}