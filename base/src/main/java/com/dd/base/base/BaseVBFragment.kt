package com.dd.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseVBFragment  <VB: ViewBinding>:Fragment(){

    var mViewBinding: VB ? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mViewBinding==null) {
            val type = javaClass.genericSuperclass as ParameterizedType
            val aClass = type.actualTypeArguments[0] as Class<*>
            val method = aClass.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
            mViewBinding = method.invoke(null, layoutInflater, container, false) as VB
            initView()
        }
        return mViewBinding!!.root
    }
    abstract fun initView()
}