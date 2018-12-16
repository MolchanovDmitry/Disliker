package com.di.penopllast.vklikesremover.data.repository.impl

import android.content.Context
import com.di.penopllast.vklikesremover.application.Util.Const

import com.di.penopllast.vklikesremover.data.repository.RepositoryPreference
import com.ironz.binaryprefs.BinaryPreferencesBuilder
import com.ironz.binaryprefs.Preferences

class RepositoryPreferenceImpl(context: Context) : RepositoryPreference {

    private val preferences: Preferences = BinaryPreferencesBuilder(context).build()

    override var token: String
        get() = preferences.getString(Const.PREF_TOKEN, "")
        set(token) = preferences.edit().putString(Const.PREF_TOKEN, token).apply()

    override var userId: Int
        get() = preferences.getInt(Const.PREF_USER_ID, 0)
        set(userId) = preferences.edit().putInt(Const.PREF_USER_ID, userId).apply()


}
