package com.di.penopllast.vklikesremover.data.repository.impl;

import android.content.Context;

import com.di.penopllast.vklikesremover.Util.Const;
import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference;
import com.ironz.binaryprefs.BinaryPreferencesBuilder;
import com.ironz.binaryprefs.Preferences;

public class RepositoryPreferenceImpl implements RepositoryPreference {

    private final Preferences preferences;

    public RepositoryPreferenceImpl(Context context) {
        preferences = new BinaryPreferencesBuilder(context).build();
    }

    @Override
    public void setToken(String token) {
        preferences.edit().putString(Const.PREF_TOKEN, token).apply();
    }

    @Override
    public String getToken() {
        return preferences.getString(Const.PREF_TOKEN, "");
    }

}
