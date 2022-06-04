package com.example.android_pa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
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
                val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
                val topBarState = rememberSaveable { (mutableStateOf(true)) }
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                SetUpBar(navBackStackEntry,bottomBarState,topBarState)

                Scaffold(
                    bottomBar =
                    {
                        BottomBar(navController = navController, bottomBarState = bottomBarState)
                    },
                    topBar =
                    {
                        TopBar(navController = navController, topBarState = topBarState)
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

@Composable
fun SetUpBar(navBackStackEntry:NavBackStackEntry?,bottomBarState:MutableState<Boolean>, topBarState:MutableState<Boolean>){
    when (navBackStackEntry?.destination?.route) {
        "login" -> {
            // Show BottomBar and TopBar
            bottomBarState.value = false
            topBarState.value = false
        }
        "home" -> {
            // Show BottomBar and TopBar
            bottomBarState.value = true
            topBarState.value = true
        }
    }
}