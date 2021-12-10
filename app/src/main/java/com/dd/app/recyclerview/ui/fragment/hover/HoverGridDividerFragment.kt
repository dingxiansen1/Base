

package com.dd.app.recyclerview.ui.fragment.hover

import android.view.View
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.dd.baseui.recyclerview.annotaion.DividerOrientation
import com.dd.baseui.recyclerview.listener.OnHoverAttachListener
import com.dd.app.R
import com.dd.app.databinding.FragmentHoverBinding
import com.dd.app.recyclerview.model.HoverHeaderModel
import com.dd.app.recyclerview.model.Model
import com.dd.app.recyclerview.model.NestedGroupModel
import com.dd.baseui.recyclerview.utils.*


class HoverGridDividerFragment : BaseHoverFragment<FragmentHoverBinding>(R.layout.fragment_hover) {

    override fun initView() {
        setHasOptionsMenu(true)

        binding.rv.linear().setup {

            onCreate {
                if (it == R.layout.item_simple_list) { // 构建嵌套网格列表
                    findView<RecyclerView>(R.id.rv).divider { // 构建间距
                        setDivider(20)
                        includeVisible = true
                        orientation = DividerOrientation.GRID
                    }.grid(2).setup {
                        addType<Model>(R.layout.item_multi_type_simple_none_margin)
                    }
                }
            }
            onBind {
                if (itemViewType == R.layout.item_simple_list) { // 为嵌套的网格列表赋值数据
                    findView<RecyclerView>(R.id.rv).models =
                        getModel<NestedGroupModel>().itemSublist
                }
            }
            addType<NestedGroupModel>(R.layout.item_simple_list)
            addType<HoverHeaderModel>(R.layout.item_hover_header)

            // 点击事件
            onClick(R.id.item) {
                when (itemViewType) {
                    R.layout.item_hover_header -> toast("悬停条目")
                    else -> toast("普通条目")
                }
            }

            // 可选项, 粘性监听器
            onHoverAttachListener = object : OnHoverAttachListener {
                override fun attachHover(v: View) {
                    ViewCompat.setElevation(v, 10F) // 悬停时显示阴影
                }

                override fun detachHover(v: View) {
                    ViewCompat.setElevation(v, 0F) // 非悬停时隐藏阴影
                }
            }
        }.models = getData()
    }

    private fun getData(): List<Any> {
        return listOf(
            HoverHeaderModel(),
            NestedGroupModel(),
            HoverHeaderModel(),
            NestedGroupModel(),
            HoverHeaderModel(),
            NestedGroupModel(),
            HoverHeaderModel(),
            NestedGroupModel(),
        )
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }

}
