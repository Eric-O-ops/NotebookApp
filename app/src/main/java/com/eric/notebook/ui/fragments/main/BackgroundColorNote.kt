package com.eric.notebook.ui.fragments.main

import android.widget.RadioButton
import com.eric.notebook.R

interface BackgroundColorNote {

    fun position(radioButton: RadioButton)
    fun backgroundColor(): String

    class Base : BackgroundColorNote {
        private var background = "#191818"
        override fun position(radioButton: RadioButton) {
            radioButton.isChecked = true
            background = when(radioButton.id) {
                R.id.radio_btn_position_1 -> { "#191818" }
                R.id.radio_btn_position_2 -> { "#EBE4C9" }
                else -> { "#571818" }
            }
        }
        override fun backgroundColor(): String = background
    }
}