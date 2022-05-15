package com.example.android_pa.view.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_pa.view.chat.ChatScreen
import com.example.android_pa.view.createPost.AddScreen
import com.example.android_pa.view.home.HomeScreen
import com.example.android_pa.view.navigation.bottomBar.BottomBar
import com.example.android_pa.view.navigation.topBar.TopBar
import com.example.android_pa.view.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomBar.Home.route
    ) {

        //App
        composable(route = BottomBar.Home.route) {
            HomeScreen(viewModel())
        }
        composable(route = BottomBar.Add.route) {
            AddScreen()
        }
        composable(route = BottomBar.Chat.route) {
            ChatScreen()
        }

        // TopAppBar
        composable(route = TopBar.Profile.route) {
            ProfileScreen()
        }
    }
}