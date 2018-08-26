package com.di.penopllast.vklikesremover.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Profile {

    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("first_name")
    @Expose
    val firstName: String? = null
    @SerializedName("last_name")
    @Expose
    val lastName: String? = null
    @SerializedName("sex")
    @Expose
    val sex: Int? = null
    @SerializedName("screen_name")
    @Expose
    val screenName: String? = null
    @SerializedName("photo_50")
    @Expose
    val photo50: String? = null
    @SerializedName("photo_100")
    @Expose
    val photo100: String? = null
    @SerializedName("online")
    @Expose
    val online: Int? = null

}
