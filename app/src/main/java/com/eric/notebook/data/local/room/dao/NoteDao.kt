package com.eric.notebook.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eric.notebook.models.NoteModel


@Dao
interface NoteDao {

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME}")
    fun loadAllNote(): LiveData<List<NoteModel>>

    @Insert(entity = NoteModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun addNote(noteModel: NoteModel)

    @Delete(entity = NoteModel::class)
    fun deleteNote(noteModel: NoteModel)

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME} WHERE noteId = :noteId")
    fun loadNoneById(noteId: Int): NoteModel
}