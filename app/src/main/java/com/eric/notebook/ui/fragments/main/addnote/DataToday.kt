package com.eric.notebook.ui.fragments.main.addnote

import java.text.SimpleDateFormat
import java.util.*

interface DataToday {

    fun getData(): String

    class Base : DataToday {

        override fun getData(): String {
            return SimpleDateFormat("d MMMM", Locale.getDefault())
                .format(Calendar.getInstance().time)
        }
    }
}