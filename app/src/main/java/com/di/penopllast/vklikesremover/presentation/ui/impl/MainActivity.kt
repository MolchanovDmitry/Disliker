package com.di.penopllast.vklikesremover.presentation.ui.impl

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.di.penopllast.vklikesremover.R
import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.presentation.presenter.MainPresenter
import com.di.penopllast.vklikesremover.presentation.presenter.impl.MainPresenterImpl
import com.di.penopllast.vklikesremover.presentation.ui.MainView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import kotlinx.android.synthetic.main.action_bar_custom.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null
    private var progressBarAction: ProgressBar? = null
    private var avatarImage: ImageView? = null
    private var title: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
        initCustomActionBar()

        post_button.setOnClickListener { onPostButtonClick() }
    }

    private fun onPostButtonClick() {
        startActivity(Intent(this, PostActivity::class.java))
    }

    private fun initCustomActionBar() {
        val actionBar = supportActionBar
        actionBar?.setDisplayShowCustomEnabled(true)

        val inflator = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflator.inflate(R.layout.action_bar_custom, null)
        v.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        progressBarAction = v.action_progress_bar
        avatarImage = v.avatar_image
        title = v.findViewById(R.id.title_text)
        actionBar?.title = ""
        actionBar?.customView = v
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data,
                        object : VKCallback<VKAccessToken> {
                            override fun onResult(res: VKAccessToken) {
                                presenter?.onVKSdkResult(res)
                            }

                            override fun onError(error: VKError) {
                                Utils.print("Не успершная авторизация")
                            }
                        })) {
            Utils.print("Третий вариант")
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun loginVk() {
        VKSdk.login(this, VKScope.FRIENDS)
    }

    override fun setTitle(s: String) {
        title?.text = s
        progressBarAction?.visibility = View.GONE
    }

    override fun setAvatar(photo50: String?) {
        Glide.with(applicationContext)
                .load(photo50)
                .apply(RequestOptions.circleCropTransform())
                .into(avatarImage ?: return)
    }
}
