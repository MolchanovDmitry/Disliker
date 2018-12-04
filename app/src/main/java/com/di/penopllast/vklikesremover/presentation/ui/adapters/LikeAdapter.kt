package com.di.penopllast.vklikesremover.presentation.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.di.penopllast.vklikesremover.R
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.entity.Post
import kotlinx.android.synthetic.main.post_item.view.*
import com.di.penopllast.vklikesremover.presentation.ui.adapters.LikeAdapter.ViewHolder


class LikeAdapter(
        private val postList: ArrayList<Post>,
        private val applicationContext: Context
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.post_item, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Utils.print("profile image ${postList[position].profileImage}")
        Utils.print("profile image ${postList[position].mainImage}")

        holder.name.text = postList[position].name
        Glide.with(applicationContext)
                .load(postList[position].profileImage)
                .into(holder.profileImage)
        Glide.with(applicationContext)
                .load(postList[position].mainImage)
                .into(holder.mainImage)
        Glide.with(applicationContext)
                .load(applicationContext.getDrawable(R.drawable.ic_like))
                .into(holder.likeImage)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage = view.profile_image
        val mainImage = view.main_image
        val name = view.profile_name_text
        val likeImage = view.like_image
    }

}