package com.dd.base.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dd.network.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            block()
        }
    }

    fun <T> launchFlow(
        requestBlock: suspend () -> ApiResponse<T>,
        startCallback: (() -> Unit)? = null,
        completeCallback: (() -> Unit)? = null): Flow<ApiResponse<T>> {
        return flow {
            emit(requestBlock())
        }.onStart {
            startCallback?.invoke()
        }.onCompletion {
            completeCallback?.invoke()
        }
    }

    /**
     * 请求不带Loading&&不需要声明LiveData
     */
    fun <T> launchAndCollect(requestBlock: suspend () -> ApiResponse<T>, listenerBuilder: ResultBuilder<T>.() -> Unit) {
        viewModelScope.launch {
            launchFlow(requestBlock).collect { response ->
                parseResultAndCallback(response, listenerBuilder)
            }
        }
    }
    private fun <T> parseResultAndCallback(response: ApiResponse<T>, listenerBuilder: ResultBuilder<T>.() -> Unit) {
        val listener = ResultBuilder<T>().also(listenerBuilder)
        when (response) {
            is ApiSuccessResponse -> listener.onSuccess(response.response)
            is ApiEmptyResponse -> listener.onDataEmpty()
            is ApiFailedResponse -> listener.onFailed(response.errorCode, response.errorMsg)
            is ApiErrorResponse -> listener.onError(response.throwable)
        }
        listener.onComplete()
    }

}