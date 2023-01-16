package com.eric.notebook.ui.fragments.main.detail

import androidx.lifecycle.ViewModel
import com.eric.notebook.data.local.repositories.NoteRepository
import com.eric.notebook.models.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun loadNoteById(id: Int) = repository.loadNoteById(id)

    fun refreshNote(noteModel: NoteModel) = repository.refreshNote(noteModel)
}