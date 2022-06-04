package com.example.android_pa.view.authentication.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_pa.view.authentication.Authentication
import com.example.android_pa.view.authentication.login.ButtonLogin

@Composable
fun Register(
    modifier: Modifier = Modifier,
    loadingProgressBar: Boolean,
    onclickRegister: (email: String, password: String) -> Unit,
    imageError: Boolean,
    navController: NavController
) {
    var email by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageRegister()

        Spacer(modifier = modifier.height(15.dp))

        EmailOutTextField(
            textValue = email,
            onValueChange = { email = it },
            onClickButton = { email = "" },
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )

        Spacer(modifier = modifier.height(15.dp))

        PasswordOutTextField(
            textValue = password,
            onValueChange = { password = it },
            onDone = {
                focusManager.clearFocus()
            }
        )

        Spacer(modifier = modifier.height(35.dp))

        ButtonRegister(
            onclick = { onclickRegister(email, password) },
            enabled = isValidate
        )

        Spacer(modifier = modifier.height(20.dp))
        TextButton(onClick = { navController.navigate(Authentication.Login.route) }) {
            Text(text = "Déjà un compte ?")
        }
    }

    //ErrorImageAuth(isImageValidate = imageError)

    ProgressBarLoading(isLoading = loadingProgressBar)
}