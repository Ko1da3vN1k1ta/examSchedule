package com.example.examschedule.bottom_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Screen1() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(listOf(
                    Color(0xFFFF0000),
                Color(0xFF00BCD4)
            )))
        ,
        text = "Screen 1",
        textAlign = TextAlign.Center
    )
}

@Composable
fun Screen2() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(listOf(
                    Color(0xFFFFEB3B),
                Color(0xFFFF5722)
            ))),
        text = "Screen 2",
        textAlign = TextAlign.Center
    )
}

@Composable
fun Screen3() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(listOf(
                    Color(0xFFFFE500),
                Color(0xFF06D8F3)
            ))),
        text = "Screen 3",
        textAlign = TextAlign.Center,

        )
}

