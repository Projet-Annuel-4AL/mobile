package com.example.android_pa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.android_pa.ui.theme.Android_paTheme
import com.example.android_pa.view.navigation.NavigationGraph
import com.example.android_pa.view.navigation.bottomBar.BottomBar
import com.example.android_pa.view.navigation.topBar.TopBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_paTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) },
                    topBar = { TopBar(navController = navController) }
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}