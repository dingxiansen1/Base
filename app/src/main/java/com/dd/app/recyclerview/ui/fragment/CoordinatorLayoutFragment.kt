package com.dd.app.recyclerview.ui.fragment

import android.widget.TextView
import com.dd.app.R
import com.dd.app.databinding.FragmentCoordinatorLayoutBinding
import com.dd.app.recyclerview.model.SimpleModel
import com.dd.base.base.BaseVDFragment
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup

class CoordinatorLayoutFragment :
    BaseVDFragment<FragmentCoordinatorLayoutBinding>(R.layout.fragment_coordinator_layout) {
    override fun initView() {
        binding.rv.linear().setup {
            addType<SimpleModel>(R.layout.item_simple)
            onBind {
                findView<TextView>(R.id.tv_simple).text = getModel<SimpleModel>().name
            }
            R.id.tv_simple.onClick {

            }
        }.models = getData()
    }

    private fun getData(): MutableList<Any> {
        // 在Model中也可以绑定数据
        return mutableListOf<Any>().apply {
            for (i in 0..9) add(SimpleModel())
        }
    }
}