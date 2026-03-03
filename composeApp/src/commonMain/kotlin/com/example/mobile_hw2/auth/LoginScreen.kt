package com.example.mobile_hw2.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.mobile_hw2.config.AppConfig
import mobilehw2.composeapp.generated.resources.Res
import mobilehw2.composeapp.generated.resources.auth_email_placeholder
import mobilehw2.composeapp.generated.resources.auth_error_empty_credentials
import mobilehw2.composeapp.generated.resources.auth_error_unknown
import mobilehw2.composeapp.generated.resources.auth_login_button
import mobilehw2.composeapp.generated.resources.auth_login_field
import mobilehw2.composeapp.generated.resources.auth_login_title
import mobilehw2.composeapp.generated.resources.auth_password_field
import mobilehw2.composeapp.generated.resources.auth_password_placeholder
import mobilehw2.composeapp.generated.resources.auth_registration_button
import mobilehw2.composeapp.generated.resources.auth_registration_text
import mobilehw2.composeapp.generated.resources.logo
import mobilehw2.composeapp.generated.resources.welcome_logo_placeholder
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
private fun LoginHeader() {
    AsyncImage(
        model = AppConfig.LOGO_ICON_URL,
        contentDescription = stringResource(Res.string.welcome_logo_placeholder),
        placeholder = painterResource(Res.drawable.logo)
    )

    Text(
        stringResource(Res.string.auth_login_title),
        color = Color.White,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun LoginForm(
    email: String,
    password: String,
    error: LoginError?,
    isLoginButtonActive: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
) {
    TextField(
        value = email,
        onValueChange = onEmailChange,
        shape = RoundedCornerShape(24.dp),
        label = { Text(stringResource(Res.string.auth_login_field)) },
        placeholder = { Text(stringResource(Res.string.auth_email_placeholder)) },
        maxLines = 1
    )

    TextField(
        value = password,
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        shape = RoundedCornerShape(24.dp),
        label = { Text(stringResource(Res.string.auth_password_field)) },
        placeholder = { Text(stringResource(Res.string.auth_password_placeholder)) },
        maxLines = 1
    )

    error?.let {
        val message = when (it) {
            is LoginError.EmptyCredentials -> stringResource(Res.string.auth_error_empty_credentials)
            is LoginError.NetworkError -> it.message
                ?: stringResource(Res.string.auth_error_unknown)
        }
        Text(message, color = Color.Red, fontSize = 14.sp)
    }

    Button(
        onClick = onLogin,
        enabled = isLoginButtonActive,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 32.dp)
    ) {
        Text(
            stringResource(Res.string.auth_login_button),
            fontSize = 24.sp
        )
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            stringResource(Res.string.auth_registration_text),
            color = Color.White,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center
        )

        TextButton(
            onClick = {},
            enabled = false,
        ) {
            Text(
                stringResource(Res.string.auth_registration_button),
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    viewModel: LoginViewModel = viewModel { LoginViewModel(createAuthRepository()) }
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.loginSuccess.collect { onLoginSuccess() }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        LoginHeader()

        LoginForm(
            email = uiState.email,
            password = uiState.password,
            error = uiState.error,
            isLoginButtonActive = uiState.isLoginButtonActive,
            onEmailChange = viewModel::onEmailChange,
            onPasswordChange = viewModel::onPasswordChange,
            onLogin = viewModel::login,
        )
    }
}
