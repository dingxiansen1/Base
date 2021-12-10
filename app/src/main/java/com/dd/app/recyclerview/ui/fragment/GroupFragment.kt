

package com.dd.app.recyclerview.ui.fragment

import android.widget.Toast
import com.dd.baseui.recyclerview.item.ItemExpand
import com.dd.app.R
import com.dd.app.databinding.FragmentGroupBinding
import com.dd.app.recyclerview.model.GroupModel
import com.dd.app.recyclerview.model.Model
import com.dd.app.recyclerview.model.NestedGroupModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment



class GroupFragment : BaseVDFragment<FragmentGroupBinding>(R.layout.fragment_group) {

    override fun initView() {
        binding.rv.linear().setup {

            // 任何条目都需要添加类型到BindingAdapter中
            addType<GroupModel>(R.layout.item_group_title)
            addType<NestedGroupModel>(R.layout.item_nested_group_title)
            addType<Model>(R.layout.item_multi_type_simple)
            R.id.item.onFastClick {
                when (itemViewType) {
                    R.layout.item_nested_group_title, R.layout.item_group_title -> {

                        val changeCount =
                            if (getModel<ItemExpand>().itemExpand) "折叠 ${expandOrCollapse()} 条" else "展开 ${expandOrCollapse()} 条"

                       toast(changeCount)
                    }
                }
            }

        }.models = getData()
    }

    private fun getData(): MutableList<GroupModel> {
        return mutableListOf<GroupModel>().apply {
            for (i in 0..4) {

                // 第二个分组存在嵌套分组
                if (i == 0) {
                    val nestedGroupModel = GroupModel().apply {
                        itemSublist =
                            listOf(NestedGroupModel(), NestedGroupModel(), NestedGroupModel())
                    }
                    add(nestedGroupModel)
                    continue
                }

                add(GroupModel())
            }
        }
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }

}
