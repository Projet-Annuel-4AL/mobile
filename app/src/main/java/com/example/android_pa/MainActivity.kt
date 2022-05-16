package com.example.android_pa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
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
                    bottomBar =
                    {
                        BottomBar(navController = navController)
                    },
                    topBar =
                    {
                        TopBar(navController = navController)
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding))
                    {
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}