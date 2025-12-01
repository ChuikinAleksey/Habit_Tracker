package com.example.habittracker.viewModel

import androidx.lifecycle.ViewModel
import com.example.habittracker.data.Habit
import com.example.habittracker.data.HabitRepository

class HabitViewModel: ViewModel(){

    private val repository = HabitRepository()
    val habitList = mutableListOf<Habit>()

    fun loadHabits(){
        habitList.addAll(repository.getAllHabits())
    }

    fun addHabit(habit: Habit){
        repository.addHabit(habit)
        habitList.add(habit)

    }

    fun deleteHabit(habitId: String){
        repository.deleteHabit(habitId)
        habitList.removeAll { it.id == habitId }
    }

}