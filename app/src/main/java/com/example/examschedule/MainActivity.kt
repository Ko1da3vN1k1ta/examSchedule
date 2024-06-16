package com.example.examschedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable

import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.compose.rememberNavController
import com.example.examschedule.bottom_navigation.BottomNavigation
import com.example.examschedule.bottom_navigation.NavGraph

import com.example.examschedule.data.ExamViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val examViewModel: ExamViewModel = viewModel()
            MainScreen(examViewModel)

            }
        }
    }
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(examViewModel: ExamViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) {
        NavGraph(navHostController = navController, examViewModel = examViewModel)
    }
}

