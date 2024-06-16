package com.example.examschedule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subject: String,
    val date: String,
    val startTime: String,
    val duration: Int,
    val examiner: String
)
