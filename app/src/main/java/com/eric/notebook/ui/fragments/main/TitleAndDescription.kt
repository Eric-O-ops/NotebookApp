package com.eric.notebook.ui.fragments.main

interface TitleAndDescription {

    fun title(): String
    fun description(): String

    class Base(private var description: String) : TitleAndDescription {

        override fun title(): String {
            var title = ""
            val charText = description.toCharArray()
            return if (description.length >= 30) {
                for (i in 0..30) {
                    title += charText[i].toString()
                }
                title
            } else {
                description
            }
        }

        override fun description(): String = description
    }
}
