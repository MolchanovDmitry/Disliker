package com.di.penopllast.vklikesremover.entity.user

import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RootUser : RootRetrofitResponse {

    @SerializedName("response")
    @Expose
    var response: List<UserInfo>? = null

}
