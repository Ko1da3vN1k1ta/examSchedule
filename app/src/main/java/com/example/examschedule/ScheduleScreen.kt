package com.example.examschedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examschedule.data.ExamViewModel

@Composable
fun ScheduleScreen(viewModel: ExamViewModel) {
    val exams by viewModel.allExams.observeAsState(emptyList())

    LazyColumn {
        items(exams) { exam ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Subject: ${exam.subject}")
                    Text(text = "Date: ${exam.date}")
                    Text(text = "Start Time: ${exam.startTime}")
                    Text(text = "Duration: ${exam.duration} minutes")
                    Text(text = "Examiner: ${exam.examiner}")
                    Button(onClick = {
                        viewModel.deleteExam(exam)
                    }) {
                        Text("Delete Exam")
                    }
                }
            }
        }
    }
}