package com.di.penopllast.vklikesremover.presentation.presenter.impl

import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference
import com.di.penopllast.vklikesremover.data.repository.ResultResponse
import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts
import com.di.penopllast.vklikesremover.presentation.presenter.MainPresenter
import com.di.penopllast.vklikesremover.presentation.ui.MainView

import javax.inject.Inject

class MainPresenterImpl(private val view: MainView) : MainPresenter,
        ResultResponse<ResponseFaveGetPosts> {

    private var repositoryPreference: RepositoryPreference? = null
        @Inject set

    private var repositoryNetwork: RepositoryNetwork? = null
        @Inject set

    init {
        DislikerApp.componentsHolder?.appComponent?.inject(this)
        getLikesData()
    }

    private fun getLikesData() {
        val token = repositoryPreference?.token as String
        if (token.isEmpty()) {
            view.loginVk()
        } else {
            repositoryNetwork?.runTestQuery(token, this)
        }
    }

    override fun onActivityResult(accessToken: String) {
        Utils.print("token = $accessToken")
        repositoryPreference?.token = accessToken
        repositoryNetwork?.runTestQuery(accessToken, this)
    }

    override fun onSuccess(obj: ResponseFaveGetPosts?) {
    }

    override fun onError(t: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
