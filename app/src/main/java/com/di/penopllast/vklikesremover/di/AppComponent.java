package com.di.penopllast.vklikesremover.di;


import com.di.penopllast.vklikesremover.MainActivity;
import com.di.penopllast.vklikesremover.application.DislikerApp;
import com.di.penopllast.vklikesremover.data.repository.impl.RepositoryNetworkImpl;
import com.di.penopllast.vklikesremover.di.module.ApiModule;
import com.di.penopllast.vklikesremover.di.module.ContextModule;
import com.di.penopllast.vklikesremover.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        ContextModule.class,
        RepositoryModule.class,
        ApiModule.class


})

public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(RepositoryNetworkImpl repositoryNetwork);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(DislikerApp application);

        AppComponent build();
    }
}
