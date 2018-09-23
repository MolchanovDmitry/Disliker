package com.di.penopllast.vklikesremover.data.repository

interface CommonCallback<T> {

    fun onSuccess(t: T?)

    fun onResponseBodyError()

    fun onError(throwable: Throwable)
}
