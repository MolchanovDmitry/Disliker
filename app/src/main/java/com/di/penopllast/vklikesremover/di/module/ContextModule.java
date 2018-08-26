package com.di.penopllast.vklikesremover.di.module;

import android.content.Context;

import com.di.penopllast.vklikesremover.application.DislikerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    @Provides
    Context provideContext(DislikerApp app) {
        return app.getApplicationContext();
    }

}
