package com.eric.notebook.timeanddate

import java.text.SimpleDateFormat
import java.util.*

interface TimeRightNow {

    fun timeRightNow(): String

    class TimeRightNowImpl : TimeRightNow {

        override fun timeRightNow(): String =
            SimpleDateFormat("HH:mm", Locale.getDefault())
                .format(Calendar.getInstance().time)

    }
}