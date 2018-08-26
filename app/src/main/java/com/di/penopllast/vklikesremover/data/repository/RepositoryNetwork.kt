package com.di.penopllast.vklikesremover.data.repository

import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts
import java.util.*

interface RepositoryNetwork {
    fun runTestQuery(token: String, callback: ResultResponse<ResponseFaveGetPosts>)
}
