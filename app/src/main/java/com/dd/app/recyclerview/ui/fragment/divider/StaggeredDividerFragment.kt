

package com.dd.app.recyclerview.ui.fragment.divider

import androidx.recyclerview.widget.RecyclerView
import com.dd.app.R
import com.dd.app.databinding.FragmentStaggeredDividerBinding
import com.dd.app.recyclerview.model.DividerModel
import com.dd.baseui.recyclerview.utils.divider
import com.dd.baseui.recyclerview.utils.setup
import com.dd.baseui.recyclerview.utils.staggered

class StaggeredDividerFragment :
    BaseDividerFragment<FragmentStaggeredDividerBinding>(R.layout.fragment_staggered_divider) {

    override fun initView() {
        binding.rv.staggered(3, RecyclerView.VERTICAL).divider {
            setDrawable(R.drawable.divider_horizontal)
            startVisible = true
            endVisible = true
        }.setup {
            addType<DividerModel>(R.layout.item_divider_vertical)
            onBind {
                // 设置动态高度
                val layoutParams = itemView.layoutParams
                layoutParams.height = getModel<DividerModel>().height
                itemView.layoutParams = layoutParams
            }
        }.models = getData()
    }

    private fun getData(): List<Any> {
        val data = mutableListOf<Any>()
        // 生成动态宽高
        for (i in 0..9) {
            when (i) {
                2 -> data.add(DividerModel(400))
                3 -> data.add(DividerModel(500))
                4 -> data.add(DividerModel(700))
                5 -> data.add(DividerModel(1000))
                8 -> data.add(DividerModel(200))
                11 -> data.add(DividerModel(1200))
                else -> data.add(DividerModel())
            }
        }
        return data
    }

}