package com.eric.notebook.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eric.notebook.base.BaseDiffUtilItemCallBack
import com.eric.notebook.models.NoteModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
    override val id: Int = 0,
    @ColumnInfo(name = "noteTitle")
    var title: String,
    @ColumnInfo(name = "noteDescription")
    var description: String,
    @ColumnInfo(name = "noteTime")
    val time: String,
    @ColumnInfo(name = "noteDate")
    val date: String,
    @ColumnInfo(name = "noteBackgroundColor")
    var backgroundColor: String
) : BaseDiffUtilItemCallBack {
    companion object {
        const val TABLE_NAME = "note_entities_table"
    }
}

