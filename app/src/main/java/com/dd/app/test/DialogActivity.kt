package com.dd.app.test

import android.graphics.Color
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.databinding.DialogActivityBinding
import com.dd.base.base.BaseVBActivity
import com.dd.base.config.AppConstants
import com.dd.baseui.utils.DensityUtils.dp2px
import com.dd.baseui.dialog.ActionSheetDialog
import com.dd.baseui.dialog.AlertDialog
import com.dd.baseui.dialog.OnSheetItemClickListener
import com.dd.baseui.dialog.SheetItem

@Route(path = AppConstants.Router.Main.A_DIALOG)
class DialogActivity : BaseVBActivity<DialogActivityBinding>() {

    companion object {
        const val DEF_BLUE = "#4762FE"
        const val DEF_RED = "#FD4A2E"
    }
    override fun initView() {
        val config = AlertDialog.Config(this).apply {
            scaleWidth = 0.78
            rightBtnColor = Color.RED

        }
        mViewBinding.firstDialog.setOnClickListener {
            AlertDialog(this, config)
                .setDialogTitle("退出当前账号")
                .setHtmlMessage("再连续登陆<font color=\"#ff0000\">15</font>天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                .setLeftButton("取消")
                .setRightButton("确认退出") {
                    showToast("确认退出")
                }
                .show()
        }
        mViewBinding.secondDialog.setOnClickListener {
            AlertDialog(this).apply {
                setCancelable(true)
                setScaleWidth(0.75) // 设置宽度，占屏幕宽度百分比
                // getMessageView().setPadding(15f.dp2px(context), 24f.dp2px(context), 15f.dp2px(context), 24f.dp2px(context))
                setMessage("你现在无法接收到新消息提醒。请到系统-设置-通知中开启消息提醒")
                // setBottomViewHeightDp(48f)
                setRightButton("确定") { showToast("OK") }
            }.show()
        }
        mViewBinding.thirdDialog.setOnClickListener {
            ActionSheetDialog(this).apply {
                setCancelable(false)
                setCanceledOnTouchOutside(false)
                setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                addSheetItem("清空消息列表", Color.parseColor(DEF_BLUE)) { item, position ->
                    showToast("clear msg list")
                }
                setCancelText("取 消")
            }.show()
        }
        mViewBinding.fourthDialog.setOnClickListener {
            ActionSheetDialog(this).apply {
             setCancelable(false)
             setCanceledOnTouchOutside(false)
                addSheetItem("发送给好友", Color.parseColor(DEF_BLUE), onItemClickListener)
                addSheetItem("转载到空间相册", Color.parseColor(DEF_BLUE), onItemClickListener)
//            addSheetItem("上传到群相册")
//            addSheetItem("保存到手机")
//            addSheetItem("收藏")
//            addSheetItem("查看聊天图片")
                setCancelText("取消哦", Color.parseColor(DEF_BLUE))
            }.show()
        }
        mViewBinding.fifthDialog.setOnClickListener {
            ActionSheetDialog(this, ActionSheetDialog.Config(this).apply {
                paddingBottom = 15f.dp2px(context)
                showCancel = true
                cancelText = "Config Cancel"
            }).apply {
                setTitle("请选择操作")
                setCancelable(false)
                setCanceledOnTouchOutside(false)
                addSheetItem("条目一", Color.parseColor(DEF_RED), onItemClickListener)
                addSheetItem("条目二", onItemClickListener)
                addSheetItem("条目三", Color.BLUE, onItemClickListener)
                addSheetItem("条目四", Color.CYAN, onItemClickListener)
                addSheetItem("条目五", onItemClickListener)
                addSheetItem("条目六", onItemClickListener)
                addSheetItem("条目七", onItemClickListener)
                addSheetItem("条目八", onItemClickListener)
                addSheetItem(SheetItem("条目九").apply { itemClickListener = onItemClickListener })
                addSheetItem(SheetItem("条目十", Color.CYAN, onItemClickListener))
            }.show()
        }
    }
    private val onItemClickListener =
        OnSheetItemClickListener { item, position ->
            showToast("item ${item.getShowName()}")
        }

    fun  showToast(msg :String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}