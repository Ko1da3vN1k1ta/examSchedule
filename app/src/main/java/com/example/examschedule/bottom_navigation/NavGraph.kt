package com.example.examschedule.bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examschedule.AddExamScreen
import com.example.examschedule.AuthScreen
import com.example.examschedule.ProfileScreen
import com.example.examschedule.ScheduleScreen
import com.example.examschedule.data.ExamViewModel

@Composable
fun NavGraph(navHostController: NavHostController, examViewModel: ExamViewModel) {
    NavHost(navController = navHostController, startDestination = "screen_1") {
        composable("screen_1") {
            AuthScreen(navController = navHostController)
        }
        composable("screen_2") {
            ScheduleScreen(viewModel = examViewModel)
        }
        composable("screen_3") {
            AddExamScreen(viewModel = examViewModel)
        }
        composable("screen_4") {
            ProfileScreen(navController = navHostController)
        }
    }
}