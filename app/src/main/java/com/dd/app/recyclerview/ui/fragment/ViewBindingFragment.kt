package com.dd.app.recyclerview.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dd.app.R
import com.dd.app.databinding.FragmentViewBindingBinding
import com.dd.app.databinding.ItemSimpleBinding
import com.dd.app.recyclerview.model.SimpleModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup


/** 更推荐使用DataBinding做MVVM架构, ViewBinding只是取代findById的简单框架而已 */
class ViewBindingFragment : Fragment(R.layout.fragment_view_binding) {

    private val binding by lazy {
        FragmentViewBindingBinding.bind(requireView())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rv.linear().setup {
            addType<SimpleModel>(R.layout.item_simple)
            onBind {
                val binding = ItemSimpleBinding.bind(itemView) // 使用ViewBinding
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