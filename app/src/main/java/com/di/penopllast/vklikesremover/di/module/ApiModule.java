package com.di.penopllast.vklikesremover.di.module;

import com.di.penopllast.vklikesremover.data.api.VkApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ApiModule {

    @Provides
    @Singleton
    VkApi provideApi(Retrofit retrofit) {
        return retrofit.create(VkApi.class);
    }

}
