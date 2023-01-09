package com.eric.notebook.ui.fragments.main

import com.eric.notebook.models.NoteModel

interface MainEvents {

    fun addNote()

    fun loadNoteList()

    fun detailNote(id: Int)

    fun removeNote(note: NoteModel)
}