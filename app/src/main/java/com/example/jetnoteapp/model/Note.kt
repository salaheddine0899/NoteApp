package com.example.jetnoteapp.model

import java.util.Date
import java.util.UUID

data class Note(val id:UUID= UUID.randomUUID(), val title:String, val details: String, val createdAt: Date)