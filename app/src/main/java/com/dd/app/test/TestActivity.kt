package com.dd.app.test

import android.Manifest
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dd.app.R
import com.dd.app.databinding.ActivityTestBinding
import com.dd.base.base.BaseVBActivity
import com.dd.base.config.AppConstants
import com.dd.base.permission.PermissionX

@Route(path = AppConstants.Router.Main.A_TEST)
class TestActivity : BaseVBActivity<ActivityTestBinding>() {

    @JvmField
    @Autowired(name = "name")
    var test :String ?= null

    override fun initView() {
        ARouter.getInstance().inject(this)
        if (test!=null){
            mViewBinding.test.setText(test)
            mViewBinding.test.setOnClickListener {
                PermissionX.init(this)
                    .permissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .onForwardToSettings { scope, deniedList ->
                        scope.showForwardToSettingsDialog(deniedList, "您需要手动在设置中允许必要的权限","确定","取消" )
                    }
                    .request{allGranted, grantedList, deniedList ->
                        if (allGranted){
                            Toast.makeText(this, "申请成功", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, "申请失败", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}