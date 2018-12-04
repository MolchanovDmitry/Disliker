package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Size(@SerializedName("type")
           @Expose
           val type: String) {

    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("width")
    @Expose
    val width: Int? = null
    @SerializedName("height")
    @Expose
    val height: Int? = null

}
