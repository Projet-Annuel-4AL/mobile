package com.example.android_pa.view.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.android_pa.view.authentication.login.Login
import com.example.android_pa.view.chat.mm


@Composable
fun LoginScreen(navController: NavController) {
    Login(
        loadingProgressBar = false,
        onclickLogin = { email: String, password: String -> mm },
        imageError = false,
        navController = navController
    )
}
