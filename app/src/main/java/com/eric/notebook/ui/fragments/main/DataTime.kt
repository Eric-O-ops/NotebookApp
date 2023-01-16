package com.eric.notebook.ui.fragments.main

import java.text.SimpleDateFormat
import java.util.*

interface DataTime {

    fun data(): String
    fun time(): String

    class Base : DataTime {

        override fun data(): String {
            return SimpleDateFormat("d MMMM", Locale.getDefault())
                .format(Calendar.getInstance().time)
        }

        override fun time(): String {
            return SimpleDateFormat("HH:mm", Locale.getDefault())
                .format(Calendar.getInstance().time)
        }
    }
}