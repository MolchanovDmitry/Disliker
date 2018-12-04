package com.di.penopllast.vklikesremover.presentation.presenter.impl

import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.data.repository.CommonCallback
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference
import com.di.penopllast.vklikesremover.entity.Post
import com.di.penopllast.vklikesremover.entity.Profile
import com.di.penopllast.vklikesremover.entity.like.RootFaveGetPost
import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.di.penopllast.vklikesremover.entity.like.ResponseFaveGetPosts
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
        getLikesData()
    }

    private fun getLikesData() {
        val token = repositoryPreference?.token as String
        val userId = repositoryPreference?.userId as Int
        if (token.isEmpty()) {
            view.loginVk()
        } else {
            repositoryNetwork?.runTestQuery(token, this)
        }
        repositoryNetwork?.getUserInfo(token, userId, this)
    }

    override fun onVKSdkResult(accessToken: VKAccessToken) {
        val userId = Integer.parseInt(accessToken.userId)
        repositoryPreference?.token = accessToken.accessToken
        repositoryPreference?.userId = userId
        repositoryNetwork?.runTestQuery(accessToken.accessToken, this)
        repositoryNetwork?.getUserInfo(accessToken.accessToken, userId, this)
    }

    override fun onSuccess(t: RootRetrofitResponse?) {
        when (t) {
            is RootUser -> {
                val userInfo = t.response?.get(0)
                view.setAvatar(userInfo?.photo50)
                view.setTitle(userInfo?.firstName + " " + userInfo?.lastName)
            }
            is RootFaveGetPost -> fillPostData(t.response)
        }
    }

    private fun fillPostData(response: ResponseFaveGetPosts?) {
        val profileList: ArrayList<Profile> = ArrayList()
        val postList: ArrayList<Post> = ArrayList()

        response?.profiles?.forEach {
            profileList.add(
                    Profile(
                            Math.abs(it.id),
                            it.firstName + ' ' + it.lastName,
                            it.photo50 ?: "")
            )
        }
        response?.groups?.forEach {
            profileList.add(Profile(Math.abs(it.id), it.name ?: "", it.photo50 ?: ""))
        }

        response?.items?.forEach { itemIt ->
            val id = itemIt.id
            val ownerId = if (itemIt.ownerId > 0) itemIt.ownerId else itemIt.ownerId * -1

            var mainImageUrl = ""
            itemIt.attachments?.forEach { innerIt ->
                innerIt.photo?.sizes?.let {
                    for (size in it) {
                        if (size.type.equals('p')) {
                            mainImageUrl = size.url ?: ""
                            break
                        }
                    }
                }
            }

            var profileImage = ""
            var profileName = ""
            for (profile in profileList) {
                if (ownerId == profile.profileId) {
                    profileImage = profile.photo ?: ""
                    profileName = profile.name
                    break
                }
            }
            postList.add(Post(
                    id,
                    ownerId,
                    mainImageUrl,
                    profileImage,
                    profileName
            ))
        }
        view.addDataToAdapter(postList)
    }


    override fun onResponseBodyError() {
        Utils.print("onResponseBodyError")
    }

    override fun onError(throwable: Throwable) {
        Utils.print("RootRetrofitResponse $throwable")
    }
}
