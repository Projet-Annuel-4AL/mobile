package com.example.android_pa.view.authentication.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_pa.R

@Composable
fun ImageRegister(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_login),
        contentDescription = "Image Login",
        modifier = modifier
            .fillMaxWidth()
            .size(300.dp),
        alignment = Alignment.Center
    )
}