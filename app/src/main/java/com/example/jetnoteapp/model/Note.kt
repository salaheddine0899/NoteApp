package com.example.jetnoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id:UUID= UUID.randomUUID(),
    val title:String,
    val details: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Date
)
