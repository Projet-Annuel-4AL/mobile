package com.example.android_pa.view.createPost

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AddScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CreatePost()
    }
}

@Composable
fun CreatePost() {
    Column(
        modifier = Modifier
            .padding(15.dp)

    ) {
        FormCreatePost()
    }
}

@Composable
fun FormCreatePost() {
    val context = LocalContext.current
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    OutlinedTextField(
        value = title,
        placeholder = { Text("title") },
        onValueChange = { title = it }
    )
    OutlinedTextField(
        value = content,
        placeholder = { Text("content") },
        onValueChange = { content = it }
    )
    Button(onClick = { }) {
        Text("Submit")
    }
}