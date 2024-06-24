package com.example.examschedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.examschedule.data.Exam
import com.example.examschedule.data.ExamViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun ProfileScreen(navController: NavController, viewModel: ExamViewModel) {
    val user by viewModel.currentUser.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        user?.let {
            Text(text = "Полное имя: ${it.fullName}")
        }
        Button(onClick = {
        viewModel.deleteAllExams()
            navController.navigate("screen_1") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
            viewModel.setCurrentUser(null)
        }) {
            Text("Выход")
        }
    }
}