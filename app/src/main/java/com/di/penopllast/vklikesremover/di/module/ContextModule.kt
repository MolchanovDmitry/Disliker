package com.di.penopllast.vklikesremover.di.module

import android.content.Context

import com.di.penopllast.vklikesremover.application.DislikerApp

import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    @Provides
    internal fun provideContext(app: DislikerApp): Context {
        return app.applicationContext
    }

}
