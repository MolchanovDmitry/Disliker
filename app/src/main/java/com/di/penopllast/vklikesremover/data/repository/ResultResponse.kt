package com.di.penopllast.vklikesremover.data.repository

interface ResultResponse<T> {

    fun onSuccess(obj: T?)

    fun onError(t: Throwable)
}
