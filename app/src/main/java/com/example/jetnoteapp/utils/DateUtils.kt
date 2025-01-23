package com.example.jetnoteapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

fun formatDate(date: Date): String {
    val formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy")
    val localDate = LocalDate.of(date.year + 1900, date.month + 1, date.date)
    return localDate.format(formatter)
}