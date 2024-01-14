package com.eric.notebook.ui.fragments.addnote

import androidx.lifecycle.ViewModel
import com.eric.notebook.data.local.repositories.NoteRepository
import com.eric.notebook.models.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun addNote(noteModel: NoteModel) {
        repository.addNote(noteModel)
    }
}