package com.dd.baseui

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar


class SnackBarView  {

    lateinit var snackBar: Snackbar
    @SuppressLint("ShowToast")
    fun long(view: View, message:String):SnackBarView{
        snackBar= Snackbar.make(view,message,LENGTH_LONG)
        return this
    }
    @SuppressLint("ShowToast")
    fun shor(view: View, message:String):SnackBarView{
        snackBar= Snackbar.make(view,message,LENGTH_SHORT)
        return this
    }

    fun setOnclick(string: String,black: () -> Unit):SnackBarView{
        snackBar.setAction(string){
            black.invoke()
        }
        return this
    }

    fun setCenter():SnackBarView{
        val snackbarView = snackBar.view
        val params = FrameLayout.LayoutParams(
            snackbarView.getLayoutParams().width,
            snackbarView.getLayoutParams().height
        );
        params.gravity = Gravity.CENTER;
        snackbarView.setLayoutParams(params);
        return this
    }

    /**
     * 显示 mSnackbar
     */
    fun show():SnackBarView {
        snackBar.show()
        return this
    }
}