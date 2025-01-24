package com.example.jetnoteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnoteapp.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("select * from notes")
    fun getAllNotes(): Flow<List<Note>>

    @Query("select * from notes where id=:id")
    suspend fun getNoteById(id:String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("delete from notes")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}