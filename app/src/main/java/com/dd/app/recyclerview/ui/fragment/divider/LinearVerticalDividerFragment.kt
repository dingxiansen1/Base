

package com.dd.app.recyclerview.ui.fragment.divider

import androidx.recyclerview.widget.RecyclerView
import com.dd.app.R
import com.dd.app.databinding.FragmentLinearVerticalDividerBinding
import com.dd.app.recyclerview.model.DividerModel
import com.dd.baseui.recyclerview.utils.divider
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup

class LinearVerticalDividerFragment :
    BaseDividerFragment<FragmentLinearVerticalDividerBinding>(R.layout.fragment_linear_vertical_divider) {

    override fun initView() {
        binding.rv.linear(RecyclerView.HORIZONTAL).divider(R.drawable.divider_vertical).setup {
            addType<DividerModel>(R.layout.item_divider_horizontal)
        }.models = getData()
    }

    fun getData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..10) {
                add(DividerModel())
            }
        }
    }

}