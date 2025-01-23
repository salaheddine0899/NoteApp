package com.example.jetnoteapp.screens.note

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnoteapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(): ViewModel() {
    var noteList = mutableStateListOf<Note>()

    fun addNote(note:Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }

    fun getALlNotes(): List<Note>{
        return  noteList
    }
}