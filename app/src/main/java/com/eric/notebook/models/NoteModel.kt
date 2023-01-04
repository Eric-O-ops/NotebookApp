package com.eric.notebook.models

data class NoteModel(
    val id: Int = 0,
    var title: String,
    var description: String,
    val time: String,
    val date: String,
    var backgroundColor: String
)
