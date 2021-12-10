

package com.dd.app.recyclerview.ui.fragment.divider

import androidx.recyclerview.widget.RecyclerView
import com.dd.baseui.recyclerview.annotaion.DividerOrientation
import com.dd.app.R
import com.dd.app.databinding.FragmentGridVerticalDividerBinding
import com.dd.app.recyclerview.model.DividerModel
import com.dd.baseui.recyclerview.utils.divider
import com.dd.baseui.recyclerview.utils.grid
import com.dd.baseui.recyclerview.utils.setup

class GridVerticalDividerFragment :
    BaseDividerFragment<FragmentGridVerticalDividerBinding>(R.layout.fragment_grid_vertical_divider) {

    override fun initView() {
        binding.rv.grid(3, RecyclerView.HORIZONTAL)
            .divider(R.drawable.divider_vertical, DividerOrientation.VERTICAL).setup {
                addType<DividerModel>(R.layout.item_divider_horizontal)
            }.models = getData()
    }

    fun getData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..12) {
                add(DividerModel())
            }
        }
    }

}