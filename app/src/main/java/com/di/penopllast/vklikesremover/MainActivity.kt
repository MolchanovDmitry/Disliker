package com.di.penopllast.vklikesremover

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.di.penopllast.vklikesremover.Util.Utils
import com.di.penopllast.vklikesremover.application.DislikerApp
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError

import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    var repositoryPreference: RepositoryPreference? = null
    @Inject set
    var repositoryNetwork: RepositoryNetwork? = null
    @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DislikerApp.componentsHolder?.appComponent?.inject(this)

        val token = repositoryPreference?.token as String
        if (token.isEmpty()) {
            VKSdk.login(this, "friends")
        } else {
            repositoryNetwork?.runTestQuery(token)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (!// Пользователь успешно авторизовался
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
                    override fun onResult(res: VKAccessToken) {
                        Utils.print("Успершная авторизация")
                        val token = res.accessToken
                        Utils.print("Token = $token")
                        repositoryPreference?.token = token
                        repositoryNetwork?.runTestQuery(token)
                    }

                    override fun onError(error: VKError) {
                        Utils.print("Не успершная авторизация")
                    }
                })) {
            Utils.print("Третий вариант")
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
