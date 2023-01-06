package com.eric.notebook.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eric.notebook.models.NoteModel


@Dao
interface NoteDao {

    @Query("SELECT * FROM ${NoteModel.TABLE_NAME}")
    fun loadAllNote(): List<NoteModel>

    @Insert(entity = NoteModel::class, onConflict = OnConflictStrategy.REPLACE)
    fun addNote(noteModel: NoteModel)

    @Delete(entity = NoteModel::class)
    fun deleteNote(noteModel: NoteModel)

}