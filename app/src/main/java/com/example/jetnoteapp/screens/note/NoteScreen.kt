package com.example.jetnoteapp.screens.note

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetnoteapp.model.Note

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NoteScreen(viewModel: NoteViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val title = remember { mutableStateOf("") }
    val details = remember { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            NoteHeader()
            NoteContainer(title = title, details = details, onSave = {
                viewModel.addNote(
                    Note(
                        title = title.value,
                        details = details.value,
                    )
                )
                title.value = ""
                details.value = ""
                Toast.makeText(
                    context, "Note added",
                    Toast.LENGTH_SHORT
                ).show()
            })
            NoteList()
        }
    }
}


@Composable
fun NoteHeader() {
    Row(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Jet Note App", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NoteContainer(
    title: MutableState<String> = mutableStateOf(""),
    details: MutableState<String> = mutableStateOf(""),
    onSave: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NoteForm(title = title, details = details, onSave = onSave)
        HorizontalDivider(modifier = Modifier.padding(3.dp))
    }
}