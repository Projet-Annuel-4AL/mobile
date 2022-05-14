package com.example.android_pa.view.navigation.bottomBar

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_pa.view.createPost.AddScreen
import com.example.android_pa.view.home.HomeScreen

@Composable
fun BottomNavigationGraph(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomBar.Home.route
    ) {
        composable(route = BottomBar.Home.route) {
            HomeScreen(viewModel())
        }
        composable(route = BottomBar.Add.route) {
            AddScreen()
        }
        composable(route = BottomBar.Chat.route) {
            Chat()
        }
    }
}