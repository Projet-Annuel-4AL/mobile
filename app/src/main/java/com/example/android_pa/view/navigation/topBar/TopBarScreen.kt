package com.example.android_pa.view.navigation.topBar

import androidx.compose.animation.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBar(navController: NavController, topBarState: MutableState<Boolean>) {
    val context = LocalContext.current
    AnimatedVisibility(
        visible = topBarState.value,
        enter = expandHorizontally() + fadeIn(),
        exit = shrinkHorizontally() + fadeOut(),
        content = {
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
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    )
}