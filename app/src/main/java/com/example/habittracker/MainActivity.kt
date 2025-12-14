package com.example.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.habittracker.ui.theme.HabitTrackerTheme
import com.example.habittracker.viewModel.HabitViewModel
import com.example.habittracker.ui.Routes
import com.example.habittracker.ui.screens.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.habittracker.ui.screens.AddHabitScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.habittracker.ui.screens.HabitDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val habitViewModel: HabitViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.Home.route
                    ) {
                        composable(Routes.Home.route) {
                            HomeScreen(
                                viewModel = habitViewModel, // нужно создать ViewModel
                                onAddHabit = {
                                    navController.navigate(Routes.AddHabit.route)
                                },
                                onHabitClick = { habitId ->
                                    navController.navigate(Routes.HabitDetails.createRoute(habitId))
                                }
                            )
                        }

                        composable(route = Routes.AddHabit.route) { navBackStackEntry ->
                            AddHabitScreen(
                                viewModel = habitViewModel,
                                onNavigateBack = { navController.navigateUp() }
                            )
                        }


                        composable(route = Routes.HabitDetails.route, arguments = listOf(navArgument("habitId") { type = NavType.StringType })) { navBackStackEntry ->
                            val habitId = navBackStackEntry.arguments?.getString("habitId") ?: ""
                            HabitDetailsScreen(
                                viewModel = habitViewModel,
                                habitId = habitId,
                                onNavigateBack = { navController.navigateUp() }
                            )
                        }
                    }


                }
            }
        }
    }
}

