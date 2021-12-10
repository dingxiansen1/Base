

package com.dd.app.recyclerview.ui.fragment

import com.dd.app.R
import com.dd.app.databinding.FragmentOneMoreTypeBinding
import com.dd.app.recyclerview.model.OneMoreTypeModel
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class OneMoreTypeFragment :
    BaseVDFragment<FragmentOneMoreTypeBinding>(R.layout.fragment_one_more_type) {

    override fun initView() {
        binding.rv.linear().setup {
            addType<OneMoreTypeModel> {
                when (type) {
                    0 -> R.layout.item_multi_type_one
                    else -> R.layout.item_multi_type_two
                }
            }
        }.models = getData()
    }

    private fun getData(): List<OneMoreTypeModel> {
        return listOf(
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(1),
            OneMoreTypeModel(1),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(1),
            OneMoreTypeModel(1),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(1),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0),
            OneMoreTypeModel(1),
            OneMoreTypeModel(0),
            OneMoreTypeModel(0)
        )
    }


}
