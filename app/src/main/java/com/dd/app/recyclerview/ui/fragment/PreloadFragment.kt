

package com.dd.app.recyclerview.ui.fragment

import com.dd.baseui.recyclerview.PageRefreshLayout
import com.dd.app.R
import com.dd.app.databinding.FragmentPreloadBinding
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


/**
 * 指定预加载, 默认反序3 开始预加载, 可设置全局变量 [PageRefreshLayout.preloadIndex]
 */
class PreloadFragment : BaseVDFragment<FragmentPreloadBinding>(R.layout.fragment_preload) {

    override fun initView() {
        binding.rv.setup {
            addType<Model>(R.layout.item_multi_type_simple)
        }

        // page.preloadIndex = 4 // 自定义列表倒数第4个开始预加载, 默认为3

        binding.page.onRefresh {
            // 模拟网络请求2秒后成功
            postDelayed({
                val data = getData()
                addData(data) {
                    index <= 3
                }
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