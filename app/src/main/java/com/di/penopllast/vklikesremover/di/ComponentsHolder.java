package com.di.penopllast.vklikesremover.di;

import com.di.penopllast.vklikesremover.application.DislikerApp;
public class ComponentsHolder {

    private final DislikerApp context;
    private AppComponent appComponent;

    public ComponentsHolder(DislikerApp context) {
        this.context = context;
    }

    public void init() {
        appComponent = DaggerAppComponent
                .builder()
                .application(context)
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
