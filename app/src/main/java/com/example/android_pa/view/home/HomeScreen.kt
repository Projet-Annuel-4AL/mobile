package com.example.android_pa.view.home

import androidx.compose.runtime.Composable
import com.example.android_pa.view.home.Posts
import com.example.android_pa.viewModel.PostViewModel


@Composable
fun HomeScreen(model: PostViewModel) {
    Posts(posts = model.postsResponse)
    model.getPosts()
}