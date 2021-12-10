

package com.dd.app.recyclerview.ui.fragment

import android.widget.TextView
import android.widget.Toast
import com.dd.app.R
import com.dd.app.databinding.FragmentSimpleBinding
import com.dd.app.recyclerview.model.SimpleModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class SimpleFragment : BaseVDFragment<FragmentSimpleBinding>(R.layout.fragment_simple) {

    override fun initView() {
        binding.rv.linear().setup {
            addType<SimpleModel>(R.layout.item_simple)
            onBind {
                findView<TextView>(R.id.tv_simple).text = getModel<SimpleModel>().name
            }
            R.id.tv_simple.onClick {
               toast("点击文本")
            }
        }.models = getData()
    }

    private fun getData(): MutableList<Any> {
        // 在Model中也可以绑定数据
        return mutableListOf<Any>().apply {
            for (i in 0..9) add(SimpleModel())
        }
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }
}