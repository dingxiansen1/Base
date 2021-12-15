package com.dd.base.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            block()
        }
    }

    fun <T> launchFlow(
        requestBlock: suspend () -> T,
        startCallback: (() -> Unit)? = null,
        completeCallback: (() -> Unit)? = null): Flow<T> {
        return flow {
            emit(requestBlock())
        }.onStart {
            startCallback?.invoke()
        }.onCompletion {
            completeCallback?.invoke()
        }
    }
}