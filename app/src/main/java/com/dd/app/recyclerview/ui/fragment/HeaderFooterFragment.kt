

package com.dd.app.recyclerview.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.dd.app.R
import com.dd.app.databinding.FragmentHeaderFooterBinding
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.bindingAdapter
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup
import com.dd.base.base.BaseVDFragment
import java.util.*


class HeaderFooterFragment :
    BaseVDFragment<FragmentHeaderFooterBinding>(R.layout.fragment_header_footer) {

    override fun initView() {
        setHasOptionsMenu(true)

        binding.rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)

            /**
             * BRV的数据集 = Header + Footer + Models
             * 所以本质上他们都是一组多类型而已, 分出来只是为了方便替换Models而不影响Header和Footer
             */

            addType<Header>(R.layout.item_multi_type_header)
            addType<Footer>(R.layout.item_multi_type_footer)
        }.models = getData()
    }

    private fun getData(): List<Model> {
        return listOf(Model(), Model())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_header_footer, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val adapter = binding.rv.bindingAdapter
        when (item.itemId) {
            R.id.menu_add_header -> adapter.addHeader(Header(), animation = true)
            R.id.menu_remove_header -> adapter.removeHeaderAt(animation = true)  // 删除头布局
            R.id.menu_clear_header -> adapter.clearHeader(animation = true) // 清除头布局
            R.id.menu_add_footer -> adapter.addFooter(Footer(), animation = true)  // 添加脚布局
            R.id.menu_remove_footer -> adapter.removeFooterAt(animation = true)  // 删除脚布局
            R.id.menu_clear_footer -> adapter.clearFooter(animation = true)  // 清除脚布局
            R.id.menu_add_item -> adapter.addModels(randomModelList(), true)
            R.id.menu_delete_item -> {
                if (adapter.modelCount > 0) {
                    adapter.mutable.removeLast()
                    adapter.notifyItemRemoved(adapter.headerCount + adapter.modelCount)
                }
            }
            R.id.menu_clear_item -> {
                val count = adapter.modelCount
                adapter.mutable.clear()
                adapter.notifyItemRangeRemoved(adapter.headerCount, count)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun randomModelList(): List<Model> {
        val random = Random()
        val num = random.nextInt(3)
        val result = arrayListOf<Model>()
        for (i in 0..num) {
            result.add(Model())
        }
        return result
    }

    class Header

    class Footer

}


