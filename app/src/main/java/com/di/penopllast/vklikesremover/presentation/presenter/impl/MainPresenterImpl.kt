package com.di.penopllast.vklikesremover.presentation.presenter.impl

import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.data.repository.CommonCallback
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference
import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.di.penopllast.vklikesremover.entity.user.RootUser
import com.di.penopllast.vklikesremover.presentation.presenter.MainPresenter
import com.di.penopllast.vklikesremover.presentation.ui.MainView
import com.vk.sdk.VKAccessToken
import javax.inject.Inject

class MainPresenterImpl(private val view: MainView) : MainPresenter, CommonCallback<RootRetrofitResponse> {

    var repositoryPreference: RepositoryPreference? = null
        @Inject set

    var repositoryNetwork: RepositoryNetwork? = null
        @Inject set

    init {
        DislikerApp.app?.componentsHolder?.appComponent?.inject(this)
    }

    override fun onVKSdkResult(accessToken: VKAccessToken) {
        val userId = Integer.parseInt(accessToken.userId)
        repositoryPreference?.token = accessToken.accessToken
        repositoryPreference?.userId = userId
        repositoryNetwork?.getUserInfo(accessToken.accessToken, userId, this)
    }

    override fun onSuccess(t: RootRetrofitResponse?) {
        when (t) {
            is RootUser -> {
                val userInfo = t.response?.get(0)
                view.setAvatar(userInfo?.photo50)
                view.setTitle(userInfo?.firstName + " " + userInfo?.lastName)

            }
        }
    }


    override fun onResponseBodyError() {
        Utils.print("onResponseBodyError")
    }

    override fun onError(throwable: Throwable) {
        Utils.print("RootRetrofitResponse $throwable")
    }
}
