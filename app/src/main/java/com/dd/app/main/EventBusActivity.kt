package com.dd.app.main

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.R
import com.dd.app.databinding.EventBusActivityBinding
import com.dd.base.base.BaseVDActivity
import com.dd.base.config.AppConstants
import com.dd.base.eventbus.receiveEvent
import com.dd.base.eventbus.sendEvent

@Route(path = AppConstants.Router.Main.A_EVENT)
class EventBusActivity : BaseVDActivity<EventBusActivityBinding>(R.layout.event_bus_activity) {
    override fun initView() {
        binding.btnSendEvent.setOnClickListener {
            val event =  binding.etEvent.text.toString()
            if (event.isBlank()) {
                Toast.makeText(this, "请输入事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event)
            }
        }
        binding.btnSendEvent2.setOnClickListener {
            val event =  binding.etEvent.text.toString()
            if (event.isBlank()) {
                Toast.makeText(this, "请输入特定事件内容", Toast.LENGTH_SHORT).show()
            } else {
                sendEvent(event,"test")
            }
        }
        // 接收特定事件
        receiveEvent<String>(tags = arrayOf("test")) {
            toast("接收特定到事件:  $it")
            binding.tvEvent2.text = it
        }
    }
    fun toast(string: String){
        Toast.makeText(this, "接收特定到事件:  $string", Toast.LENGTH_LONG).show()
    }
}