package com.di.penopllast.vklikesremover.di

import com.di.penopllast.vklikesremover.application.DislikerApp

class ComponentsHolder(private val context: DislikerApp) {
    var appComponent: AppComponent? = null
        private set

    fun init() {
        appComponent = DaggerAppComponent
                .builder()
                .application(context)
                .build()
    }

}
