package com.di.penopllast.vklikesremover.entity

data class Post(
        val id: Int,
        val ownerId: Int,
        val mainImage: String?,
        val profileImage: String?,
        val name: String
)
