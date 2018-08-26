package com.di.penopllast.vklikesremover.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Place {

    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("latitude")
    @Expose
    val latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    val longitude: Double? = null
    @SerializedName("created")
    @Expose
    val created: Int? = null
    @SerializedName("icon")
    @Expose
    val icon: String? = null
    @SerializedName("country")
    @Expose
    val country: String? = null
    @SerializedName("city")
    @Expose
    val city: String? = null

}
