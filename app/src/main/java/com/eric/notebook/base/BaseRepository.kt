package com.eric.notebook.base

import androidx.lifecycle.LiveData
import com.eric.notebook.models.NoteModel

abstract class BaseRepository {

    abstract fun loadAllNone(): LiveData<List<NoteModel>>

    abstract fun addNote(noteModel: NoteModel)

    abstract fun deleteNote(noteModel: NoteModel)
}