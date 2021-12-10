package com.dd.app

import android.content.Context
import com.dd.base.base.BaseApp
import com.dd.base.toast.ToastX
import com.dd.baseui.recyclerview.utils.BRV
import com.dd.baseui.recyclerview.statelayout.StateConfig
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.MaterialHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class app : BaseApp() {

    lateinit var mContext: Context

    override fun onCreate() {
        super.onCreate()
        mContext=this
        // 初始化BindingAdapter的默认绑定ID
        BRV.modelId = BR.m
        // 初始化ToastX的默认绑定ID
        ToastX.modelId= BR.toast

        /**
         *  推荐在Application中进行全局配置缺省页, 当然同样每个页面可以单独指定缺省页.
         *  具体查看 https://github.com/liangjingkanji/StateLayout
         */
        StateConfig.apply {
            emptyLayout = R.layout.layout_empty
            errorLayout = R.layout.layout_error
            loadingLayout = R.layout.layout_loading

            setRetryIds(R.id.msg)

            onLoading {
                // 此生命周期可以拿到LoadingLayout创建的视图对象, 可以进行动画设置或点击事件.
            }
        }

        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            MaterialHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            ClassicsFooter(context)
        }
    }
}