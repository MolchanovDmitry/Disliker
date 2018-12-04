package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comments {

    @SerializedName("count")
    @Expose
    val count: Int? = null
    @SerializedName("groups_can_post")
    @Expose
    val groupsCanPost: Boolean? = null
    @SerializedName("can_post")
    @Expose
    val canPost: Int? = null

}
