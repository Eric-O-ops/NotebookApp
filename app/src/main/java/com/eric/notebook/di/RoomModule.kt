package com.eric.notebook.di

import android.content.Context
import androidx.room.Room
import com.eric.notebook.data.local.room.NoteRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideNoteRoomDataBase(@ApplicationContext context: Context): NoteRoomDataBase =
        Room.databaseBuilder(
            context,
            NoteRoomDataBase::class.java,
            "note_room_database"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}