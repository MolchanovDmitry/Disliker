package com.di.penopllast.vklikesremover.data.api

import com.di.penopllast.vklikesremover.entity.like.RootFaveGetPost
import com.di.penopllast.vklikesremover.entity.user.RootUser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

    @GET("/method/fave.getPosts")
    fun getLikes(@Query("offset") offset: Int, @Query("count") count: Int,
                 @Query("extended") extended: Int, @Query("access_token") token: String,
                 @Query("v") version: String): Call<RootFaveGetPost>

    @GET("/method/users.get")
    fun getUser(@Query("access_token") token: String, @Query("user_ids") userId: Int,
                @Query("fields") field: String, @Query("name_case") nameCase: String,
                @Query("version") version: String): Call<RootUser>
}
