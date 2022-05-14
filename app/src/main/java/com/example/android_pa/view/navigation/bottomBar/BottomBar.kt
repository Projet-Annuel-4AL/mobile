package com.example.android_pa.view.navigation.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar (
    val route: String,
    val title: String,
    val icon: ImageVector,
){
    object Home: BottomBar(
        route = "accueil",
        title = "Accueil",
        icon = Icons.Default.Home
    )

    object Add: BottomBar(
        route = "submit",
        title = "Ajouter",
        icon = Icons.Default.Add
    )

    object Chat: BottomBar(
        route = "conversation",
        title = "Conversation",
        icon = Icons.Default.Email
    )
}
