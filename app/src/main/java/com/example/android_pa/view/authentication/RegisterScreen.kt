package com.example.android_pa.view.authentication

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.android_pa.view.authentication.login.Login
import com.example.android_pa.view.authentication.register.Register
import com.example.android_pa.view.chat.mm


@Composable
fun RegisterScreen(navController: NavController) {
    Register(
        loadingProgressBar = false,
        onclickRegister = { email: String, password: String -> mm },
        imageError = false,
        navController = navController
    )
}
