package com.eric.notebook.ui.fragments.main.addnote

import java.text.SimpleDateFormat
import java.util.*

interface TimeRightNow {

    fun getTime(): String

    class Base : TimeRightNow {

        override fun getTime(): String {
            return SimpleDateFormat("HH:mm", Locale.getDefault())
                .format(Calendar.getInstance().time)
        }
    }
}