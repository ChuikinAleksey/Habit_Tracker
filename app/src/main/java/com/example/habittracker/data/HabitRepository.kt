package com.example.habittracker.data

class HabitRepository {
    private val habits = mutableListOf<Habit>()

    fun getAllHabits(): List<Habit> {
        return habits
    }

    fun addHabit(habit: Habit) {
        habits.add(habit)
    }

    fun deleteHabit(habitId: String) {
        habits.removeAll{ it.id == habitId }

    }

    fun getHabitById(habitId: String): Habit? {
        return habits.find { it.id == habitId }
    }
}
