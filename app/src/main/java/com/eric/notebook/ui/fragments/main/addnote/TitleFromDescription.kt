package com.eric.notebook.ui.fragments.main.addnote

interface TitleFromDescription {

    fun getTitle(text: String): String

    class Base : TitleFromDescription {

        override fun getTitle(text: String): String {
            var title = ""
            val charText = text.toCharArray()
            return if (text.length >= 30) {
                for (i in 0..30) {
                    title += charText[i].toString()
                }
                title
            } else {
                text
            }
        }
    }
}
