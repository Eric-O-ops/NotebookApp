package com.eric.notebook.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eric.notebook.data.local.room.dao.NoteDao
import com.eric.notebook.models.NoteModel

@Database(
    entities = [
        NoteModel::class
    ], version = 1
)
abstract class NoteRoomDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}