package com.example.android_pa.view.navigation.topBar

sealed class TopBar(val route: String, val label: String) {
    object Profile : TopBar(route = "profile", label = "Profile")
}