package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostSource(

        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("platform")
        @Expose
        val platform: String? = null

)
