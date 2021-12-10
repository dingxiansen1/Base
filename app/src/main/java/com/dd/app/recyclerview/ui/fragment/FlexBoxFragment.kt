

package com.dd.app.recyclerview.ui.fragment

import com.dd.app.R
import com.dd.app.databinding.FragmentFlexBoxBinding
import com.dd.app.recyclerview.model.FlexTagModel
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class FlexBoxFragment : BaseVDFragment<FragmentFlexBoxBinding>(R.layout.fragment_flex_box) {

    override fun initView() {
        /**
         * Google开源项目-flexBox-layout
         * 更多使用方法查看项目地址: https://github.com/google/flexbox-layout
         */
     //   binding.rv.layoutManager = FlexboxLayoutManager(activity)

        binding.rv.setup {
            addType<FlexTagModel>(R.layout.item_flex_tag)
        }.models = getData()
    }

    private fun getData(): List<FlexTagModel> {
        return listOf(
            FlexTagModel("淘宝"),
            FlexTagModel("微信"),
            FlexTagModel("QQ"),
            FlexTagModel("UC浏览器"),
            FlexTagModel("京东"),
            FlexTagModel("滴滴"),
            FlexTagModel("抖音"),
            FlexTagModel("今日头条")
        )
    }

}
