package com.di.penopllast.vklikesremover.presentation.ui

import com.di.penopllast.vklikesremover.entity.Post

interface MainView {
    fun loginVk()
    fun setAvatar(photo50: String?)
    fun setTitle(s: String)
    fun addDataToAdapter(postList: ArrayList<Post>)
}