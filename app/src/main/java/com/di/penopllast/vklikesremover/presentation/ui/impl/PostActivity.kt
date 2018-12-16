package com.di.penopllast.vklikesremover.presentation.ui.impl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.di.penopllast.vklikesremover.R
import com.di.penopllast.vklikesremover.entity.Post
import com.di.penopllast.vklikesremover.presentation.presenter.PostPresenter
import com.di.penopllast.vklikesremover.presentation.presenter.impl.PostPresenterImpl
import com.di.penopllast.vklikesremover.presentation.ui.PostView
import com.di.penopllast.vklikesremover.presentation.ui.adapters.LikeAdapter
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity(), PostView {

    private var presenter: PostPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        recycler_view.layoutManager = LinearLayoutManager(this)
        presenter = PostPresenterImpl(this)
    }

    override fun addDataToAdapter(postList: ArrayList<Post>) {
        recycler_view.adapter = LikeAdapter(postList, applicationContext)
        progress_bar.visibility = View.GONE
    }
}
