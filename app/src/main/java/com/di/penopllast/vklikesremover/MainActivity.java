package com.di.penopllast.vklikesremover;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.di.penopllast.vklikesremover.Util.Utils;
import com.di.penopllast.vklikesremover.application.DislikerApp;
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork;
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject RepositoryPreference repositoryPreference;
    @Inject RepositoryNetwork repositoryNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DislikerApp.getComponentsHolder().getAppComponent().inject(this);

        String token = repositoryPreference.getToken();
        if (token.isEmpty()) {
            VKSdk.login(this, "friends");
        } else {
            repositoryNetwork.runTestQuery(token);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                Utils.print("Успершная авторизация");
                String token = res.accessToken;
                Utils.print("Token = " + token);
                repositoryPreference.setToken(token);
                repositoryNetwork.runTestQuery(token);
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Utils.print("Не успершная авторизация");
            }
        })) {
            Utils.print("Третий вариант");
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
