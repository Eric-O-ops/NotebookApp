package com.eric.notebook.timeanddate


import java.text.SimpleDateFormat
import java.util.*

interface DataToday {

    fun dataToday(): String

    class DataTodayImpl : DataToday {

        override fun dataToday(): String =
            SimpleDateFormat("d MMMM", Locale.getDefault())
                .format(Calendar.getInstance().time)

    }
}
