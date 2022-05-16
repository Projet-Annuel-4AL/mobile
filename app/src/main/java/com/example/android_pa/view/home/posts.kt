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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Size
import com.example.android_pa.R
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
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column() {
            UserPost(post)
            DatePost()
            TitlePost(post)
            ImagePost(post = post)
            PanelSocial()
        }
    }
}

@Composable
fun UserPost(post: Post) {
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
}

@Composable
fun DatePost() {
    Text(
        text = "Posté il y a 30 min",
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun TitlePost(post: Post) {
    Text(
        text = post.desc,
        style = MaterialTheme.typography.caption,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun ImagePost(post: Post) {
    Image(
        painter = rememberImagePainter(data = post.imageUrl,
            builder = {
                size(Size.ORIGINAL)
            }),
        contentDescription = post.desc,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()

    )

    Divider(color = Color.White, thickness = 1.dp)
}

@Composable
fun PanelSocial() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_thumb_up),
                contentDescription = "like post"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = "comment post"
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "share post"
            )
        }
    }
}