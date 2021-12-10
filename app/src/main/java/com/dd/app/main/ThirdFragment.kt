package cn.onestravel.one.navigation.demo

import android.util.Log
import android.widget.Toast
import com.dd.app.R
import com.dd.app.databinding.Fragment3Binding
import com.dd.base.base.BaseVBFragment
import com.dd.base.config.AppConstants
import com.dd.base.eventbus.receiveEvent
import com.dd.base.eventbus.sendEvent
import com.dd.base.route.RouteCenter

class ThirdFragment : BaseVBFragment<Fragment3Binding>() {
    override fun initView() {
        Log.e("初始化","完成")
        // 接收事件
        receiveEvent<String> {
            Toast.makeText(activity, "接收到事件:  $it", Toast.LENGTH_SHORT).show()
            mViewBinding!!.tvEvent.text = it
        }
        // 接收特定事件
        receiveEvent<String>(tags = arrayOf("test")) {
            Toast.makeText(activity, "接收特定到事件:  $it", Toast.LENGTH_SHORT).show()
            mViewBinding!!.tvEvent2.text = it
        }

        mViewBinding!!.btnSendToCurrent.setOnClickListener {
            sendEvent("发送事件给当前")
        }
        mViewBinding!!.btnOpenAct.setOnClickListener {
            RouteCenter.navigate(AppConstants.Router.Main.A_EVENT)
        }
    }
}

