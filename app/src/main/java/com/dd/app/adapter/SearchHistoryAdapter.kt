package com.dd.app.adapter

import com.dd.baseui.flowLayout.FlowAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.dd.app.R
import androidx.appcompat.widget.AppCompatTextView
import android.widget.Toast

/**
 * @author zwl
 * @date on 2021/8/5
 */
class SearchHistoryAdapter : FlowAdapter<String?>() {
    override fun getView(parent: ViewGroup?, item: Any?, position: Int): View? {
        return LayoutInflater.from(parent!!.context).inflate(R.layout.item_search_history, null)
    }

    override fun initView(view: View?, item: Any?, position: Int) {
        val textView: AppCompatTextView = view!!.findViewById(R.id.item_tv)
        textView.text = item.toString()
        textView.setOnClickListener { v: View? ->
            Toast.makeText(
                view.context, item.toString(), Toast.LENGTH_SHORT
            ).show()
        }
    }
}