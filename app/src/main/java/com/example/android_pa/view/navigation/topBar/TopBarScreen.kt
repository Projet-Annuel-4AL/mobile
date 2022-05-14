package com.example.android_pa.view.navigation.topBar

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBar(navController: NavController) {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Palit") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, "backIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp,
        actions = {
            IconButton(onClick = { navController.navigate(TopBar.Profile.route) }) {
                Icon(Icons.Filled.AccountCircle, contentDescription = "Localized description")
            }
        }
    )
}