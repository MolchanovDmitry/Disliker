package com.di.penopllast.vklikesremover.application.Util

import android.util.Log

class Utils private constructor() {

    init {
        throw AssertionError()
    }

    companion object {
        private const val TAG = "DisLiker"

        fun print(message: String) {
            Log.i(TAG, message)
        }
    }
}
