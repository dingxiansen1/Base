

package com.dd.app.recyclerview.ui.fragment.divider

import com.dd.baseui.recyclerview.annotaion.DividerOrientation
import com.dd.app.R
import com.dd.app.databinding.FragmentGridDividerBinding
import com.dd.app.recyclerview.model.DividerModel
import com.dd.baseui.recyclerview.utils.divider
import com.dd.baseui.recyclerview.utils.grid
import com.dd.baseui.recyclerview.utils.setup

class GridDividerFragment :
    BaseDividerFragment<FragmentGridDividerBinding>(R.layout.fragment_grid_divider) {

    override fun initView() {
        binding.rv.grid(3).divider {
            setDrawable(R.drawable.divider_horizontal)
            orientation = DividerOrientation.GRID
            includeVisible = true
        }.setup {
            addType<DividerModel>(R.layout.item_divider_vertical)
        }.models = getData()
    }

    fun getData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..10) add(DividerModel())
        }
    }

}