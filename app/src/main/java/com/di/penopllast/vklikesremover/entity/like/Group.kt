package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Group(@SerializedName("id")
            @Expose
            val id: Int) {

    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("screen_name")
    @Expose
    val screenName: String? = null
    @SerializedName("is_closed")
    @Expose
    val isClosed: Int? = null
    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("photo_50")
    @Expose
    val photo50: String? = null
    @SerializedName("photo_100")
    @Expose
    val photo100: String? = null
    @SerializedName("photo_200")
    @Expose
    val photo200: String? = null

}
