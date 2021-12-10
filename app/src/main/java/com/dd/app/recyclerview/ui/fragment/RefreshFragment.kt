

package com.dd.app.recyclerview.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.dd.app.R
import com.dd.app.databinding.FragmentRefreshBinding
import com.dd.app.recyclerview.model.DoubleItemModel
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment



class RefreshFragment : BaseVDFragment<FragmentRefreshBinding>(R.layout.fragment_refresh) {

    private val total = 30

    override fun initView() {
        setHasOptionsMenu(true)
        toast("右上角菜单可以操作刷新结果, 默认2s结束")
        binding.rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<DoubleItemModel>(R.layout.item_multi_type_two)
        }

        binding.page.onRefresh {

            val runnable = { // 模拟网络请求, 创建假的数据集
                val data = getData()
                addData(data) {
                    index < total // 判断是否有更多页
                }

                // addData(data, binding.rv.bindingAdapter, isEmpty = {
                //     true // 此处判断是否存在下一页
                // }, hasMore = {
                //     false // 此处判断是否显示空布局
                // })
            }
            postDelayed(runnable, 0)


        }.autoRefresh()
    }

    private fun getData(): List<Any> {
        return mutableListOf<Any>().apply {
            for (i in 0..9) {
                when (i) {
                    1, 2 -> add(DoubleItemModel())
                    else -> add(Model())
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_refresh, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> binding.page.showLoading()  // 加载中
            R.id.menu_pull_refresh -> binding.page.autoRefresh() // 下拉刷新
            R.id.menu_refresh -> binding.page.refresh() // 静默刷新
            R.id.menu_content -> binding.page.showContent() // 加载成功
            R.id.menu_error -> binding.page.showError(force = true) // 强制加载错误
            R.id.menu_empty -> binding.page.showEmpty() // 空数据
            R.id.menu_refresh_success -> binding.page.finish() // 刷新成功
            R.id.menu_refresh_fail -> binding.page.finish(false) // 刷新失败
            R.id.menu_no_load_more -> binding.page.finishLoadMoreWithNoMoreData() // 没有更多数据
        }
        return super.onOptionsItemSelected(item)
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }
}
