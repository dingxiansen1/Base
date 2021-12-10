

package com.dd.app.recyclerview.ui.fragment

import com.dd.app.R
import com.dd.app.databinding.FragmentUpFetchBinding
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


/**
 * 聊天室列表下拉加载历史记录示例
 */
class UpFetchFragment : BaseVDFragment<FragmentUpFetchBinding>(R.layout.fragment_up_fetch) {

    override fun initView() {
        binding.rv.setup {
            addType<Model>(R.layout.item_multi_type_simple)
        }

        binding.page.upFetchEnabled = true

        binding.page.onRefresh {
            // 模拟网络请求2秒后成功
            postDelayed({
                val data = getData()
                addData(data) { index <= 2 }
            }, 1000)
        }.showLoading() //  加载中(缺省页)
    }

    /**
     * 模拟数据
     */
    private fun getData(): MutableList<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..9) {
                add(Model())
            }
        }
    }


}