package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geo(
        
        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("coordinates")
        @Expose
        val coordinates: String? = null,
        @SerializedName("place")
        @Expose
        val place: Place? = null
)
