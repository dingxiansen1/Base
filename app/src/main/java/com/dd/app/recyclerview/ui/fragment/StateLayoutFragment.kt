

package com.dd.app.recyclerview.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.dd.app.R
import com.dd.app.databinding.FragmentStateLayoutBinding
import com.dd.app.recyclerview.model.DoubleItemModel
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment


class StateLayoutFragment :
    BaseVDFragment<FragmentStateLayoutBinding>(R.layout.fragment_state_layout) {

    override fun initView() {
        setHasOptionsMenu(true)
        binding.rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<DoubleItemModel>(R.layout.item_multi_type_two)
        }.models = getData()

    }

    private fun getData(): List<Any> {
        return listOf(
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            DoubleItemModel(),
            DoubleItemModel(),
            DoubleItemModel(),
            Model(),
            Model(),
            Model()
        )
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_state, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_loading -> binding.state.showLoading()  // 加载中
            R.id.menu_content -> binding.state.showContent() // 加载成功
            R.id.menu_error -> binding.state.showError() // 加载错误
            R.id.menu_empty -> binding.state.showEmpty() // 加载失败
        }
        return super.onOptionsItemSelected(item)
    }


}
