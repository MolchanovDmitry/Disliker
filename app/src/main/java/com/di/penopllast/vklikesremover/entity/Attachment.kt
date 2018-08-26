package com.di.penopllast.vklikesremover.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attachment {

    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("photo")
    @Expose
    val photo: Photo? = null

}
