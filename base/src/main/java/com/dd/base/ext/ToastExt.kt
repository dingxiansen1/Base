package com.dd.base.ext

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
/**
 * 短Toast
 * */
fun Activity.showToast(content: String): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
fun Activity.showToast(content: Int): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
fun Fragment.showToast(content: Int): Toast {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
fun Context.showToast(content: String): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
fun Context.showToast(content: Int): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
/**
 * 长Toast
 * */
fun Activity.showToastLong(content: String): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_LONG)
    toast.show()
    return toast
}
fun Fragment.showToastLong(content: String): Toast {
    val toast = Toast.makeText(this.activity, content, Toast.LENGTH_LONG)
    toast.show()
    return toast
}
fun Context.showToastLong(content: String): Toast {
    val toast = Toast.makeText(this, content, Toast.LENGTH_LONG)
    toast.show()
    return toast
}




