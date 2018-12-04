package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseFaveGetPosts {

    @SerializedName("count")
    @Expose
    val count: Int? = null
    @SerializedName("items")
    @Expose
    val items: List<Item>? = null
    @SerializedName("profiles")
    @Expose
    val profiles: List<Profile>? = null
    @SerializedName("groups")
    @Expose
    val groups: List<Group>? = null

}
