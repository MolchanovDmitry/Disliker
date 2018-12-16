package com.di.penopllast.vklikesremover.entity.user

import com.di.penopllast.vklikesremover.entity.RootRetrofitResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo(
        @SerializedName("id")
        @Expose
        var id: Int? = null,
        @SerializedName("first_name")
        @Expose
        var firstName: String? = null,
        @SerializedName("last_name")
        @Expose
        var lastName: String? = null,
        @SerializedName("photo_50")
        @Expose
        var photo50: String? = null
) : RootRetrofitResponse