package com.di.penopllast.vklikesremover.application

import android.app.Application

import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.di.ComponentsHolder
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKAccessTokenTracker
import com.vk.sdk.VKSdk


class DislikerApp : Application() {

    internal var componentsHolder: ComponentsHolder? = null

    private val vkAccessTokenTracker: VKAccessTokenTracker = object : VKAccessTokenTracker() {
        override fun onVKAccessTokenChanged(oldToken: VKAccessToken?, newToken: VKAccessToken?) {
            if (newToken == null) {
                // VKAccessToken is invalid
                Utils.print("Не валидный токен")
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        vkAccessTokenTracker.startTracking()
        VKSdk.initialize(applicationContext)

        componentsHolder = ComponentsHolder(this)
        componentsHolder?.init()
    }

    companion object {
        var app: DislikerApp? = null
            private set
    }
}
