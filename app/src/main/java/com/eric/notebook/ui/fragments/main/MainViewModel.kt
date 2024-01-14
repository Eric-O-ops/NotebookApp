package com.eric.notebook.ui.fragments.main

import androidx.lifecycle.ViewModel
import com.eric.notebook.data.local.repositories.NoteRepository
import com.eric.notebook.models.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    fun loadAllNote() = repository.loadAllNote()

    fun removeNote(note: NoteModel) = repository.deleteNote(note)

    fun isLinearLayout() = repository.getLinearState()

    fun changeLinearState(value: Boolean) = repository.changeLinerState(value)

    fun searchNote(value: String) = repository.searchNote(value)
}