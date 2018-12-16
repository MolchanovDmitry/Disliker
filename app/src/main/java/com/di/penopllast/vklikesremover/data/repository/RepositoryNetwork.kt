package com.di.penopllast.vklikesremover.data.repository

import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse

interface RepositoryNetwork {
    fun getPosts(token: String, callback: CommonCallback<RootRetrofitResponse>)
    fun getUserInfo(token: String, userId: Int, callback: CommonCallback<RootRetrofitResponse>)
}
