package com.example.fp_bpii

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SharedPreferencesUser(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "UserPrefs"
        private const val KEY_USERPASSWORD = "key_user_password"
        private const val KEY_USER_EMAIL = "key_user_email"
        private const val KEY_USER_NAME = "key_user_name"
        private const val KEY_IS_LOGGED_IN = "key_is_logged_in"
    }

    // Menyimpan data pengguna
    fun saveUser(name: String, isLoggedIn: Boolean) {
        sharedPreferences.edit().apply {
            putString(KEY_USER_NAME, name)
            putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun savePwd(password: String, isLoggedIn: Boolean) {
        sharedPreferences.edit().apply {
            Log.d("SharedPreferencesUser", "Menyimpan password: $password")
            putString(KEY_USERPASSWORD, password)
            putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun saveEmail(email: String, isLoggedIn: Boolean) {
        sharedPreferences.edit().apply {
            Log.d("SharedPreferencesUser", "Menyimpan email: $email")
            putString(KEY_USER_EMAIL, email)
            putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
            apply()
        }
    }

    fun getUserName(): String? {
        return sharedPreferences.getString(KEY_USER_NAME, null)
    }

    fun getUserPassword(): String? {
        return sharedPreferences.getString(KEY_USERPASSWORD, null)
    }

    fun getUserEmail(): String? {
        return sharedPreferences.getString(KEY_USER_EMAIL, null)
    }


    // Mengecek apakah pengguna sudah login
    fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // Menghapus data pengguna
    fun clearUserData() {
        sharedPreferences.edit().clear().apply()
    }
}


