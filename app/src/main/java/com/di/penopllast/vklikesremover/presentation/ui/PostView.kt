package com.di.penopllast.vklikesremover.presentation.ui

import com.di.penopllast.vklikesremover.entity.Post

interface PostView {
    fun addDataToAdapter(postList: ArrayList<Post>)
}