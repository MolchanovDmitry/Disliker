package com.di.penopllast.vklikesremover.application;

import android.app.Application;

import com.di.penopllast.vklikesremover.Util.Utils;
import com.di.penopllast.vklikesremover.data.api.VkApi;
import com.di.penopllast.vklikesremover.di.ComponentsHolder;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;



public class DislikerApp extends Application {

    private static ComponentsHolder componentsHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(getApplicationContext());

        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }

    public static ComponentsHolder getComponentsHolder() {
        return componentsHolder;
    }

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                // VKAccessToken is invalid
                Utils.print("Не валидный токен");
            }
        }
    };



}
