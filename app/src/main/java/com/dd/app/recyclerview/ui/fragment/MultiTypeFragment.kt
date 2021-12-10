

package com.dd.app.recyclerview.ui.fragment

import android.widget.Toast
import com.dd.app.R
import com.dd.app.databinding.FragmentMultiTypeBinding
import com.dd.app.recyclerview.model.DoubleItemModel
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.bindingAdapter
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment



class MultiTypeFragment : BaseVDFragment<FragmentMultiTypeBinding>(R.layout.fragment_multi_type) {

    override fun initView() {
        binding.rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<DoubleItemModel>(R.layout.item_multi_type_two)
        }.models = getData()

        // 点击事件
        binding.rv.bindingAdapter.onClick(R.id.item) {
            when (itemViewType) {
                R.layout.item_multi_type_simple -> toast("类型1")
                else -> toast("类型2")
            }
        }
    }

    private fun getData(): MutableList<Any> {
        return mutableListOf(
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model()
        )
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }
}
