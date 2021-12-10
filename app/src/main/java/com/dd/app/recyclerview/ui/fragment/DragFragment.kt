

package com.dd.app.recyclerview.ui.fragment

import com.dd.baseui.recyclerview.annotaion.ItemOrientation
import com.dd.app.R
import com.dd.app.databinding.FragmentDragBinding
import com.dd.app.recyclerview.model.DragModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment

class DragFragment : BaseVDFragment<FragmentDragBinding>(R.layout.fragment_drag) {

    override fun initView() {

        // 侧滑删除会改变数据的内容
        binding.rv.linear().setup {
            addType<DragModel>(R.layout.item_drag)
        }.models = getData()
    }

    private fun getData(): List<Any> {
        return listOf(
            DragModel(),
            DragModel(),
            DragModel(ItemOrientation.NONE), // 不支持侧滑
            DragModel(),
            DragModel(),
            DragModel(ItemOrientation.NONE), // 不支持侧滑
            DragModel(),
            DragModel()
        )
    }

}