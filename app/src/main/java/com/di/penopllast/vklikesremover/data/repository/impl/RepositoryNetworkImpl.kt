package com.di.penopllast.vklikesremover.data.repository.impl

import com.di.penopllast.vklikesremover.BuildConfig.VK_VERSION
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.data.api.VkApi
import com.di.penopllast.vklikesremover.data.repository.CommonCallback
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.entity.RootFaveGetPost
import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.di.penopllast.vklikesremover.entity.user.RootUser

import javax.inject.Inject

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryNetworkImpl : RepositoryNetwork {

    var vkApi: VkApi? = null
        @Inject set

    init {
        DislikerApp.componentsHolder?.appComponent?.inject(this)
    }

    override fun runTestQuery(token: String, callback: CommonCallback<RootRetrofitResponse>) {

        vkApi?.getLikes(0, 2, 1, token, VK_VERSION)?.enqueue(
                object : Callback<RootFaveGetPost> {
                    override fun onResponse(call: Call<RootFaveGetPost>,
                                            response: Response<RootFaveGetPost>) {
                        callback.onSuccess(response.body())
                        Utils.print("Нам вернулся объект")
                    }

                    override fun onFailure(call: Call<RootFaveGetPost>, t: Throwable) {
                        Utils.print("Произошла какая-то хуйня")
                    }
                })
    }

    override fun getUserInfo(token: String, userId: Int, callback: CommonCallback<RootRetrofitResponse>) {
        vkApi?.getUser(token, userId, "photo_50", "Nom", VK_VERSION)?.enqueue(
                object : Callback<RootUser> {
                    override fun onResponse(call: Call<RootUser>, response: Response<RootUser>) {
                        response.body()?.let {
                            callback.onSuccess(response.body())
                        }
                    }

                    override fun onFailure(call: Call<RootUser>, t: Throwable) {
                        callback.onError(t)
                    }

                })

    }
}
