

package com.dd.app.recyclerview.ui.fragment.divider

import com.dd.app.R
import com.dd.app.databinding.FragmentLinearHorizontalDividerBinding
import com.dd.app.recyclerview.model.DividerModel
import com.dd.baseui.recyclerview.utils.divider
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup

class LinearHorizontalDividerFragment :
    BaseDividerFragment<FragmentLinearHorizontalDividerBinding>(R.layout.fragment_linear_horizontal_divider) {

    override fun initView() {
        binding.rv.linear().divider(R.drawable.divider_horizontal).setup {
            addType<DividerModel>(R.layout.item_divider_vertical)
        }.models = getData()
    }

    fun getData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..3) {
                add(DividerModel())
            }
        }
    }

}