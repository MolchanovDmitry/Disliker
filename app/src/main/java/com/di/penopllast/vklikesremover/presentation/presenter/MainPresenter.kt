package com.di.penopllast.vklikesremover.presentation.presenter

import com.vk.sdk.VKAccessToken

interface MainPresenter {
    fun onVKSdkResult(accessToken: VKAccessToken)

}
