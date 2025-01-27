package com.example.jetnoteapp.repository

import com.example.jetnoteapp.data.NoteDatabaseDao
import com.example.jetnoteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note: Note) = noteDatabaseDao.save(note=note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note=note)
    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO)
}