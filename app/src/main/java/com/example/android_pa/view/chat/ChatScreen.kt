package com.example.android_pa.view.chat

import androidx.compose.runtime.Composable
import com.example.android_pa.view.authentication.login.Login

val mm = ""

@Composable
fun ChatScreen() {
    Login(
        loadingProgressBar = false,
        onclickLogin = { email: String, password: String -> mm },
        imageError = false
    )
}