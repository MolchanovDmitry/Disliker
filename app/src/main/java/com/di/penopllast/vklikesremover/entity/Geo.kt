package com.di.penopllast.vklikesremover.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Geo {

    @SerializedName("type")
    @Expose
    val type: String? = null
    @SerializedName("coordinates")
    @Expose
    val coordinates: String? = null
    @SerializedName("place")
    @Expose
    val place: Place? = null

}
