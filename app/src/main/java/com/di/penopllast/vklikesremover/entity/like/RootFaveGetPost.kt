package com.di.penopllast.vklikesremover.entity.like

import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RootFaveGetPost : RootRetrofitResponse {

    @SerializedName("response")
    @Expose
    val response: ResponseFaveGetPosts? = null

}
