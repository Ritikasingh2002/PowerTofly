package com.hackygirls.kavachh.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.hackygirls.kavachh.R

class SessionManager(context: Context) {

    private var prefs: SharedPreferences? =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val COOKIE = "u56tlr0dwc7o5oht6rdndwcmm4nlbh26"
    }

    fun saveValue(key: String, value: String) {
        val editor = prefs?.edit()
        editor?.putString(key, value)
        editor?.apply()

    }

    fun getValue(key: String): String? {
        return prefs?.getString(key, null)
    }

    fun deleteValue(key: String) {
        val editor = prefs?.edit()
        editor?.putString(key, null)
        editor?.apply()
    }
}