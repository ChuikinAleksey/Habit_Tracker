package com.example.habittracker.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.habittracker.data.Habit
import com.example.habittracker.viewModel.HabitViewModel


@Composable
fun HabitDetailsScreen(
    viewModel: HabitViewModel,
    habitId: String,
    onNavigateBack: () -> Unit
){
    var habit by remember { mutableStateOf<Habit?>(null) }

    LaunchedEffect(habitId) {
        habit = viewModel.getHabitById(habitId)
    }










}