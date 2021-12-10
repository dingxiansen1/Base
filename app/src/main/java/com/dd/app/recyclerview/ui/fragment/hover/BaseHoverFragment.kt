

package com.dd.app.recyclerview.ui.fragment.hover

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.dd.app.R
import com.dd.base.base.BaseVDFragment

/**
 * 创建菜单
 */
abstract class BaseHoverFragment<B : ViewDataBinding>(@LayoutRes contentLayoutId: Int = 0) :
    BaseVDFragment<B>(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_hover, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        item.onNavDestinationSelected(findNavController())
        return true
    }
}
