

package com.dd.app.recyclerview.ui.fragment.hover

import android.view.View
import android.widget.Toast
import androidx.core.view.ViewCompat
import com.dd.baseui.recyclerview.listener.OnHoverAttachListener
import com.dd.app.R
import com.dd.app.databinding.FragmentHoverBinding
import com.dd.app.recyclerview.model.HoverHeaderModel
import com.dd.app.recyclerview.model.Model
import com.dd.baseui.recyclerview.utils.linear
import com.dd.baseui.recyclerview.utils.setup


class HoverLinearFragment : BaseHoverFragment<FragmentHoverBinding>(R.layout.fragment_hover) {

    override fun initView() {
        binding.rv.linear().setup {
            addType<Model>(R.layout.item_multi_type_simple)
            addType<HoverHeaderModel>(R.layout.item_hover_header)
            models = getData()

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

        }
    }
    fun toast(string: String){
        Toast.makeText(activity, string, Toast.LENGTH_LONG).show()
    }
    private fun getData(): List<Any> {
        return listOf(
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            HoverHeaderModel(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model(),
            Model()
        )
    }

}
