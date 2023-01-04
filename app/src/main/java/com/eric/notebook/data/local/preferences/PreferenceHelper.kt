package com.eric.notebook.data.local.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val preferenceHelper: SharedPreferences =
        context.getSharedPreferences("userData", Context.MODE_PRIVATE)

    operator fun invoke(): SharedPreferences = preferenceHelper
}