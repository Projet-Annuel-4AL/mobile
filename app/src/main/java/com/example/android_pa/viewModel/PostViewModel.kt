package com.example.android_pa.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_pa.model.Post
import com.example.android_pa.network.ApiService
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var postsResponse: List<Post> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getPosts() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val posts = apiService.getPosts()
                postsResponse = posts
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}