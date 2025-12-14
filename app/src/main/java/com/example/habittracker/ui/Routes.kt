package com.example.habittracker.ui

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object AddHabit : Routes("addhabit")
    object Statistics : Routes("statistics")
    object HabitDetails : Routes("habit_details/{habitId}") {
        fun createRoute(habitId: String) = "habit_details/$habitId"
    }
}

