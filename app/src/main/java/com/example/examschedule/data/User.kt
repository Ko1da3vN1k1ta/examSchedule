package com.example.examschedule.data

import androidx.room.Entity

@Entity(tableName = "users")
data class User(
    val userId: String,
    val fullName: String,
    val password: String
)