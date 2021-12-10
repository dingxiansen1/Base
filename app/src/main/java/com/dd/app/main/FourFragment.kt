package cn.onestravel.one.navigation.demo

import android.util.Log
import android.widget.Toast
import com.dd.app.databinding.Fragment4Binding
import com.dd.base.base.BaseVBFragment
import com.dd.base.eventbus.receiveEvent
import com.dd.base.eventbus.sendEvent

/**
 * @author onestravel
 * @createTime 2019-08-04 11:52
 * @description TODO
 */
class FourFragment : BaseVBFragment<Fragment4Binding>() {
    override fun initView() {
        mViewBinding!!.btnSendEvent.setOnClickListener {
            val event =  mViewBinding!!.etEvent.text.toString()
            if (event.isBlank()) {
                Toast.makeText(activity, "请输入事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event)
            }
        }
        mViewBinding!!.btnSendEvent2.setOnClickListener {
            val event =  mViewBinding!!.etEvent.text.toString()
            if (event.isBlank()) {
                Toast.makeText(activity, "请输入特定事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event,"test")
            }
        }
        // 接收特定事件
        receiveEvent<String>(tags = arrayOf("test")) {
            Toast.makeText(activity, "接收特定到事件:  $it", Toast.LENGTH_SHORT).show()
            mViewBinding!!.tvEvent2.text = it
        }
    }
}

