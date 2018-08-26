package com.di.penopllast.vklikesremover.application

import android.app.Application

import com.di.penopllast.vklikesremover.Util.Utils
import com.di.penopllast.vklikesremover.data.api.VkApi
import com.di.penopllast.vklikesremover.di.ComponentsHolder
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKAccessTokenTracker
import com.vk.sdk.VKSdk


class DislikerApp : Application() {

    internal val vkAccessTokenTracker: VKAccessTokenTracker = object : VKAccessTokenTracker() {
        override fun onVKAccessTokenChanged(oldToken: VKAccessToken?, newToken: VKAccessToken?) {
            if (newToken == null) {
                // VKAccessToken is invalid
                Utils.print("Не валидный токен")
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        vkAccessTokenTracker.startTracking()
        VKSdk.initialize(applicationContext)

        componentsHolder = ComponentsHolder(this)
        componentsHolder!!.init()
    }

    companion object {

        var componentsHolder: ComponentsHolder? = null
            private set
    }


}
