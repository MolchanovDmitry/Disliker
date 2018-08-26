package com.di.penopllast.vklikesremover.data.api

import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts
import com.di.penopllast.vklikesremover.entity.RootFaveGetPost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

    @GET("/method/fave.getPosts")
    fun getLikes(@Query("offset") offset: Int, @Query("count") count: Int,
                 @Query("extended") extended: Int,
                 @Query("access_token") token: String,
                 @Query("v") version: String): Call<RootFaveGetPost>
}
