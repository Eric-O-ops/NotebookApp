package com.eric.notebook.data.local.repositories

import androidx.lifecycle.LiveData
import com.eric.notebook.base.BaseRepository
import com.eric.notebook.data.local.room.NoteRoomDataBase
import com.eric.notebook.models.NoteModel
import javax.inject.Inject
class NoteRepository @Inject constructor(
    private val roomDataBase: NoteRoomDataBase
) : BaseRepository() {

    override fun loadAllNote(): LiveData<List<NoteModel>> {
        return roomDataBase.noteDao().loadAllNote()
    }

    override fun addNote(noteModel: NoteModel) {
        roomDataBase.noteDao().addNote(noteModel)
    }

    override fun deleteNote(noteModel: NoteModel) {
        roomDataBase.noteDao().deleteNote(noteModel)
    }

    override fun loadNoteById(id: Int): NoteModel {
        return roomDataBase.noteDao().loadNoteById(id)
    }

    override fun refreshNote(noteModel: NoteModel) {
        roomDataBase.noteDao().refreshNote(noteModel)
    }
}