package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Attachment(

        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("photo")
        @Expose
        val photo: Photo? = null
)
