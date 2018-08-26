package com.di.penopllast.vklikesremover.di.module;

import android.content.Context;

import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork;
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference;
import com.di.penopllast.vklikesremover.data.repository.impl.RepositoryNetworkImpl;
import com.di.penopllast.vklikesremover.data.repository.impl.RepositoryPreferenceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    RepositoryNetwork provideRepositoryNetwork() {
        return new RepositoryNetworkImpl();
    }

    @Provides
    @Singleton
    RepositoryPreference provideRepositoryPreference(Context context) {
        return new RepositoryPreferenceImpl(context);
    }


}
