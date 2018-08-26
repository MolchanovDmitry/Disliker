package com.di.penopllast.vklikesremover.data.repository.impl

import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.data.api.VkApi
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.data.repository.ResultResponse
import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts
import com.di.penopllast.vklikesremover.entity.RootFaveGetPost

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

    override fun runTestQuery(token: String, callback: ResultResponse<ResponseFaveGetPosts>) {

        vkApi?.getLikes(0, 2, 1, token, "5.80")?.enqueue(
                object : Callback<RootFaveGetPost> {
                    override fun onResponse(call: Call<RootFaveGetPost>,
                                            response: Response<RootFaveGetPost>) {
                        callback.onSuccess(response.body()?.response)
                        Utils.print("Нам вернулся объект")
                    }

                    override fun onFailure(call: Call<RootFaveGetPost>, t: Throwable) {
                        Utils.print("Произошла какая-то хуйня")
                    }
                })
    }
}
