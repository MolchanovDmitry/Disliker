package com.di.penopllast.vklikesremover.data.api;

import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts;
import com.di.penopllast.vklikesremover.entity.RootFaveGetPost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkApi {

    @GET("/method/fave.getPosts")
    Call<RootFaveGetPost> getLikes(@Query("offset") int offset, @Query("count") int count,
                                   @Query("extended") int extended,
                                   @Query("access_token") String token,
                                   @Query("v") String version);
}
