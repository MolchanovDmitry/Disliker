package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Reposts(

        @SerializedName("count")
        @Expose
        val count: Int? = null,
        @SerializedName("user_reposted")
        @Expose
        val userReposted: Int? = null
)
