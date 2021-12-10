package cn.onestravel.one.navigation.demo

import android.util.Log
import com.dd.app.adapter.SearchHistoryAdapter
import com.dd.app.databinding.Fragment2Binding
import com.dd.base.base.BaseVBFragment
import java.util.ArrayList

/**
 * @author onestravel
 * @createTime 2019-08-04 11:52
 * @description TODO
 */
class SecondFragment : BaseVBFragment<Fragment2Binding>() {
    override fun initView() {
        Log.e("初始化","完成")
        val adapter = SearchHistoryAdapter()
        mViewBinding!!.flowList.setAdapter(adapter)
        adapter.setNewData(getHistoryList())
    }
    fun getHistoryList(): MutableList<String?> {
        val historyList: MutableList<String> = ArrayList()
        historyList.add("衣服")
        historyList.add("T恤宽松男")
        historyList.add("男鞋")
        historyList.add("香蕉苹果")
        historyList.add("休闲裤")
        historyList.add("牛仔裤")
        historyList.add("红薯")
        historyList.add("西红柿")
        historyList.add("玩具大白")
        historyList.add("丝绵被")
        historyList.add("保温杯")
        historyList.add("花生油")
        historyList.add("折叠椅")
        historyList.add("小米笔记本")
        historyList.add("三星手机")
        historyList.add("显示器")
        historyList.add("小风扇")
        historyList.add("卫生纸")
        historyList.add("视频教程")
        historyList.add("学习")
        return historyList.toMutableList()
    }
}

