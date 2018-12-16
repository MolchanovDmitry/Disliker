package com.di.penopllast.vklikesremover.di


import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.data.repository.impl.RepositoryNetworkImpl
import com.di.penopllast.vklikesremover.di.module.ApiModule
import com.di.penopllast.vklikesremover.di.module.ContextModule
import com.di.penopllast.vklikesremover.di.module.RepositoryModule
import com.di.penopllast.vklikesremover.presentation.presenter.impl.MainPresenterImpl
import com.di.penopllast.vklikesremover.presentation.presenter.impl.PostPresenterImpl

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component

@Singleton
@Component(modules = arrayOf(ContextModule::class, RepositoryModule::class, ApiModule::class))
interface AppComponent {

    fun inject(mainPresenter: MainPresenterImpl)

    fun inject(repositoryNetwork: RepositoryNetworkImpl)

    fun inject(postPresenter: PostPresenterImpl)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DislikerApp): Builder

        fun build(): AppComponent
    }
}
