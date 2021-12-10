

package com.dd.app.recyclerview.ui.fragment

import android.widget.Toast
import com.dd.app.R
import com.dd.app.databinding.FragmentInterfaceBinding
import com.dd.app.recyclerview.model.BaseInterfaceModel
import com.dd.app.recyclerview.model.InterfaceModel1
import com.dd.app.recyclerview.model.InterfaceModel2
import com.dd.app.recyclerview.model.InterfaceModel3
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class InterfaceFragment : BaseVDFragment<FragmentInterfaceBinding>(R.layout.fragment_interface) {

    override fun initView() {
        binding.rv.linear().setup {
            addType<BaseInterfaceModel>(R.layout.item_interface_type)
            R.id.item.onClick {
                toast("点击文本")
            }
        }.models = getData()
    }

    private fun getData(): List<Any> {
        // 在Model中也可以绑定数据
        return List(3) { InterfaceModel1("item $it") } +
                List(3) { InterfaceModel2(it, "item ${3 + it}") } +
                List(3) { InterfaceModel3("item ${6 + it}") }
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }
}