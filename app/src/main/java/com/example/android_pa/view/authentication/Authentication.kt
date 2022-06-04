package com.example.android_pa.view.authentication

sealed class Authentication(val route: String, val label: String) {
    object Login : Authentication(route = "login", label = "Login")
    object Register : Authentication(route = "register", label = "Register")
}
