package com.di.penopllast.vklikesremover.presentation.ui.impl

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.di.penopllast.vklikesremover.R

import com.di.penopllast.vklikesremover.application.Util.Utils
import com.di.penopllast.vklikesremover.presentation.presenter.MainPresenter
import com.di.penopllast.vklikesremover.presentation.presenter.impl.MainPresenterImpl
import com.di.penopllast.vklikesremover.presentation.ui.MainView
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError


class MainActivity : AppCompatActivity(), MainView {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (!// Пользователь успешно авторизовался
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
                    override fun onResult(res: VKAccessToken) {
                        Utils.print("Успершная авторизация")
                        presenter?.onActivityResult(res.accessToken)
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
        VKSdk.login(this, "friends")
    }
}
