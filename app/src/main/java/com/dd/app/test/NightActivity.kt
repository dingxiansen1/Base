package com.dd.app.test

import com.alibaba.android.arouter.facade.annotation.Route
import com.dd.app.R
import com.dd.app.databinding.NightActivityBinding
import com.dd.base.base.BaseVDActivity
import com.dd.base.config.AppConstants
import com.dd.base.utils.NightModel

@Route(path = AppConstants.Router.Main.A_NIGHT)
class NightActivity :BaseVDActivity<NightActivityBinding>(R.layout.night_activity){
    override fun initView() {
       binding.test.setOnClickListener {
           NightModel.updataNightModel()
       }
    }
}