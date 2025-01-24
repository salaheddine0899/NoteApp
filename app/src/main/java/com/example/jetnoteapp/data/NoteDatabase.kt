package com.example.jetnoteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetnoteapp.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao(): NoteDatabaseDao
}