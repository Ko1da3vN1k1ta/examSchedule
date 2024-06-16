package com.example.examschedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examschedule.data.Exam
import com.example.examschedule.data.ExamViewModel

@Composable
fun AddExamScreen(viewModel: ExamViewModel) {
    var subject by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var examiner by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = subject, onValueChange = { subject = it }, label = { Text("Subject") })
        TextField(value = date, onValueChange = { date = it }, label = { Text("Date") })
        TextField(value = startTime, onValueChange = { startTime = it }, label = { Text("Start Time") })
        TextField(value = duration, onValueChange = { duration = it }, label = { Text("Duration") })
        TextField(value = examiner, onValueChange = { examiner = it }, label = { Text("Examiner") })
        Button(onClick = {
            if (subject.isNotEmpty() && date.isNotEmpty() && startTime.isNotEmpty() && duration.isNotEmpty() && examiner.isNotEmpty()) {
                viewModel.insertExam(
                    Exam(
                        subject = subject,
                        date = date,
                        startTime = startTime,
                        duration = duration.toInt(),
                        examiner = examiner
                    )
                )
            }
        }) {
            Text("Add Exam")
        }
    }
}