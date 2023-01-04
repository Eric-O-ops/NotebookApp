package com.eric.notebook.data.local.preferences.userdata

import com.eric.notebook.data.local.preferences.PreferenceConstants
import com.eric.notebook.data.local.preferences.PreferenceHelper

class UserPreferenceData(
    private val preferenceHelper: PreferenceHelper
) {
    var onBoard: Boolean
        get() = preferenceHelper()
            .getBoolean(PreferenceConstants.ON_BOARD_ACTIVATED, false)
        set(value) = preferenceHelper().edit()
            .putBoolean(PreferenceConstants.ON_BOARD_ACTIVATED, value).apply()

}