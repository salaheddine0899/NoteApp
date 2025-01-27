package com.example.jetnoteapp.screens.note

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnoteapp.model.Note
import com.example.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged()
                .collect{
                    listOfNotes ->
                    if (listOfNotes.isEmpty()){
                        Log.d("empty", "empty list")
                    }else{
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

    fun addNote(note:Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun removeNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }

    /*fun getALlNotes(): List<Note>{
        noteList.value
        return  noteList
    }*/
}