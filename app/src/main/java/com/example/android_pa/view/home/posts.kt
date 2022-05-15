package com.example.android_pa.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.android_pa.model.Post

@Composable
fun Posts(posts: List<Post>) {
    LazyColumn {
        itemsIndexed(items = posts) { index, item ->
            PostItem(post = item)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Card(
        modifier = Modifier
            .height(400.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .size(48.dp)
                        .padding(4.dp)
                ) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Localized description")
                }
                Text(text = post.name)
            }
            Text(
                text = "Posté il y a 30 min",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Comment je gère mes projets en AL...",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            ImagePost(post = post)
        }

    }
}

@Composable
fun ImagePost(post: Post) {
    Image(
        painter = rememberImagePainter(data = "https://img.lemde.fr/2016/08/04/0/13/534/267/1440/720/60/0/a9b1471_17806-xsb5q2.jpg",
            builder = {
                placeholder(coil.base.R.drawable.notification_action_background)
            }),
        contentDescription = post.desc,
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}