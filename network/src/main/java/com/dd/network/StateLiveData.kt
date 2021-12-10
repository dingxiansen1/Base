package com.dd.network

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * <pre>
 * @author : wutao
 * time   : 2021/10/18
 * desc   :
 * version: 1.1
</pre> *
 */
typealias StateLiveData<T> = LiveData<ApiResponse<T>>
typealias StateMutableLiveData<T> = MutableLiveData<ApiResponse<T>>

@MainThread
inline fun <T> StateMutableLiveData<T>.observeState(
    owner: LifecycleOwner,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    val listener = ResultBuilder<T>().also(listenerBuilder)
    observe(owner) { apiResponse ->
        when (apiResponse) {
            is ApiSuccessResponse -> listener.onSuccess(apiResponse.response)
            is ApiEmptyResponse -> listener.onDataEmpty()
            is ApiFailedResponse -> listener.onFailed(apiResponse.errorCode, apiResponse.errorMsg)
            is ApiErrorResponse -> listener.onError(apiResponse.throwable)
        }
        listener.onComplete()
    }
}

@MainThread
inline fun <T> LiveData<ApiResponse<T>>.observeState(
    owner: LifecycleOwner,
    listenerBuilder: ResultBuilder<T>.() -> Unit
) {
    val listener = ResultBuilder<T>().also(listenerBuilder)
    observe(owner) { apiResponse ->
        when (apiResponse) {
            is ApiSuccessResponse -> listener.onSuccess(apiResponse.response)
            is ApiEmptyResponse -> listener.onDataEmpty()
            is ApiFailedResponse -> listener.onFailed(apiResponse.errorCode, apiResponse.errorMsg)
            is ApiErrorResponse -> listener.onError(apiResponse.throwable)
        }
        listener.onComplete()
    }
}

class ResultBuilder<T> {
    var onSuccess: (data: T?) -> Unit = {}
    var onDataEmpty: () -> Unit = {}
    var onFailed: (errorCode: Int?, errorMsg: String?) -> Unit = { _, errorMsg ->
        errorMsg?.let { }
    }
    var onError: (e: Throwable) -> Unit = { e ->
        e.message?.let {  }
    }
    var onComplete: () -> Unit = {}
}