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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.examschedule.data.ExamViewModel
import com.example.examschedule.data.User

@Composable
fun AuthScreen(navController: NavController, viewModel: ExamViewModel) {
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf<String?>(null) }

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("animation.json"))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(modifier = Modifier.padding(10.dp),
            value = userId,
            onValueChange = { userId = it },
            label = { Text("User ID") }
        )
        TextField(modifier = Modifier.padding(10.dp),
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        if (errorText != null) {
            Text(text = errorText!!, color = Color.Red)
        }

        Button(modifier = Modifier.padding(10.dp),
            onClick = {
                if (userId.isNotEmpty() && password.isNotEmpty()) {
                    if (userId == "B-203456") {
                        val user = User(
                            userId = userId,
                            fullName = "Колдаев Никита",
                            password = "5454"
                        )
                        viewModel.setCurrentUser(user)
                        navController.navigate("screen_3")
                    } else {
                        errorText = "Неверный логин"
                    }
                } else {
                    errorText = "Введите User ID и пароль"
                }
            }
        ) {
            Text("Логин")
        }
    }
}
