package com.example.habittracker.ui.screens



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.habittracker.viewModel.HabitViewModel

import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.data.Habit
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddHabitScreen(
    viewModel: HabitViewModel,
    onNavigateBack: () -> Unit
) {
    var title: String by remember { mutableStateOf("") }
    var description: String by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Добавить привычку", fontSize = 24.sp) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack)
                    { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад") }
                }
            )
        }
    )
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { newValue -> title = newValue },
                label = { Text("Название привычки") }
            )

            Spacer(modifier = Modifier.padding(16.dp))


            OutlinedTextField(
                value = description,
                onValueChange = { newValue -> description = newValue },
                label = { Text("Описание")},
                maxLines = 3)

            Spacer(modifier = Modifier.padding(32.dp))

            Button(
                onClick = {
                    val newHabit = Habit(
                        id = "habit_${System.currentTimeMillis()}",
                        title = title,
                        description = description,
                        color = Color.Blue.toArgb(),
                        createdDate = "2024-01-15"
                    )
                    viewModel.addHabit(newHabit)
                    onNavigateBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Сохранить")
            }

        }

    }
}


