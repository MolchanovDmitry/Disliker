package com.di.penopllast.vklikesremover.di.module

import com.di.penopllast.vklikesremover.data.api.VkApi

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = arrayOf(RetrofitModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): VkApi {
        return retrofit.create(VkApi::class.java)
    }

}
