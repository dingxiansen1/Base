

package com.dd.app.recyclerview.ui.fragment

import com.dd.baseui.recyclerview.annotaion.ItemOrientation
import com.dd.app.R
import com.dd.app.databinding.FragmentSwipeBinding
import com.dd.app.recyclerview.model.SwipeModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class SwipeFragment : BaseVDFragment<FragmentSwipeBinding>(R.layout.fragment_swipe) {

    override fun initView() {
        // 侧滑删除会改变数据的内容
        binding.rv.linear().setup {
            addType<SwipeModel>(R.layout.item_swipe)
        }.models = getData()
    }

    private fun getData(): List<SwipeModel> {
        return listOf(
            SwipeModel(ItemOrientation.LEFT), // 左划
            SwipeModel(),
            SwipeModel(ItemOrientation.RIGHT), // 右划
            SwipeModel(),
            SwipeModel(ItemOrientation.NONE),  // 不支持侧滑
            SwipeModel(),
            SwipeModel(ItemOrientation.NONE), // 不支持侧滑
            SwipeModel()
        )
    }


}
