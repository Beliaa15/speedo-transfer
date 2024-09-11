package com.belia.speedotransfer.util

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    companion object {
        private const val PREFS_NAME = "my_prefs"
        private const val TOKEN_KEY = "auth_token"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // Save the token
    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }

    // Retrieve the token
    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }

    // Optional: Clear the token
    fun clearToken() {
        sharedPreferences.edit().remove(TOKEN_KEY).apply()
    }
}