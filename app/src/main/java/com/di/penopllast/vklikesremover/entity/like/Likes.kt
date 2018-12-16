package com.di.penopllast.vklikesremover.entity.like

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Likes(

        @SerializedName("count")
        @Expose
        val count: Int? = null,
        @SerializedName("user_likes")
        @Expose
        val userLikes: Int? = null,
        @SerializedName("can_like")
        @Expose
        val canLike: Int? = null,
        @SerializedName("can_publish")
        @Expose
        val canPublish: Int? = null
)
