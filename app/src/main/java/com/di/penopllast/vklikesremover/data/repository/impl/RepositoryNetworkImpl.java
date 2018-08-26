package com.di.penopllast.vklikesremover.data.repository.impl;

import com.di.penopllast.vklikesremover.Util.Utils;
import com.di.penopllast.vklikesremover.application.DislikerApp;
import com.di.penopllast.vklikesremover.data.api.VkApi;
import com.di.penopllast.vklikesremover.data.repository.RepositoryNetwork;
import com.di.penopllast.vklikesremover.entity.ResponseFaveGetPosts;
import com.di.penopllast.vklikesremover.entity.RootFaveGetPost;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryNetworkImpl implements RepositoryNetwork {

    @Inject VkApi vkApi;

    public RepositoryNetworkImpl() {
        DislikerApp.getComponentsHolder().getAppComponent().inject(this);
    }

    @Override
    public void runTestQuery(String token) {
        if (vkApi == null) {
            Utils.print("Нелевой vk api");
        } else {
            vkApi.getLikes(0, 2, 1, token, "5.80").enqueue(
                    new Callback<RootFaveGetPost>() {
                        @Override
                        public void onResponse(Call<RootFaveGetPost> call, Response<RootFaveGetPost> response) {
                            RootFaveGetPost data = response.body();
                            Utils.print("Нам вернулся объект");
                        }

                        @Override
                        public void onFailure(Call<RootFaveGetPost> call, Throwable t) {
                            Utils.print("Произошла какая-то хуйня");
                        }
                    });
        }
    }
}
