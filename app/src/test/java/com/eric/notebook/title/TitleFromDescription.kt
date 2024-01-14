package com.eric.notebook.title

interface TitleFromDescription {

    fun time(description: String): String

    class TitleImpl : TitleFromDescription {
        override fun time(description: String): String {
            val charSentence = description.toCharArray()
            var title = ""

            for (i in 0..30) {
                title += charSentence[i].toString()
            }
            return title
        }
    }
}
