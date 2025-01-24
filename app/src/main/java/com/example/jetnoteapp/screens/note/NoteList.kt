package com.example.jetnoteapp.screens.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteList(viewModel: NoteViewModel= hiltViewModel()) {
    val notesSaved =  viewModel.getALlNotes()
    LazyColumn(modifier = Modifier.padding(4.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notesSaved){
            Card(
                modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                onClick = {viewModel.removeNote(it)}
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = it.title, style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold)
                    Text(text = it.details, style = MaterialTheme.typography.bodyMedium)
                    //Text(text = formatDate(it.createdAt), style = MaterialTheme.typography.bodySmall,)
                }
            }
        }
    }
}