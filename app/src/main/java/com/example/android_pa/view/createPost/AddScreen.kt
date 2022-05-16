package com.example.android_pa.view.createPost

import android.graphics.drawable.Drawable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android_pa.R

@Composable
fun AddScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column()
            {
                EditAction(drawable = R.drawable.ic_comment)
                CustomTextForEdit(text = "Texte")
            }
            Column()
            {
                EditAction(drawable = R.drawable.ic_picture)
                CustomTextForEdit(text = "Image")
            }
            Column()
            {
                EditAction(drawable = R.drawable.ic_video)
                CustomTextForEdit(text = "Video")
            }
            Column()
            {
                EditAction(drawable = R.drawable.ic_link)
                CustomTextForEdit(text = "Lien")
            }
        }
    }
}

@Composable
fun CustomTextForEdit(text: String){
    Text(text = text)
}

@Composable
fun EditAction(drawable: Int) {
    IconButton(
        onClick = { },
        modifier = Modifier
            .then(Modifier.size(50.dp))
            .border(1.dp, Color.Gray, shape = CircleShape)
    ) {
        Icon(
            painter = painterResource(id = drawable),
            contentDescription = "text edit",
            tint = Color.Black,
        )
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


}

@Composable
fun TextInput() {
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