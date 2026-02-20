package com.example.mobile_hw2

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mobile_hw2.config.AppConfig
import mobilehw2.composeapp.generated.resources.Res
import mobilehw2.composeapp.generated.resources.login_button
import mobilehw2.composeapp.generated.resources.login_field
import mobilehw2.composeapp.generated.resources.login_title
import mobilehw2.composeapp.generated.resources.logo
import mobilehw2.composeapp.generated.resources.logo_placeholder
import mobilehw2.composeapp.generated.resources.name_placeholder
import mobilehw2.composeapp.generated.resources.password_field
import mobilehw2.composeapp.generated.resources.password_placeholder
import mobilehw2.composeapp.generated.resources.registration_button
import mobilehw2.composeapp.generated.resources.registration_text
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen() {

    var login by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        AsyncImage(
            model = AppConfig.LOGO_ICON_URL,
            contentDescription = stringResource(Res.string.logo_placeholder),
            placeholder = painterResource(Res.drawable.logo)
        )

        Text(
            stringResource(Res.string.login_title),
            color = Color.White,
            fontSize = 32.sp,
            lineHeight = 48.sp,
            textAlign = TextAlign.Center
        )

        TextField(
            value = login,
            onValueChange = { login = it },
            shape = RoundedCornerShape(24.dp),
            label = { Text(stringResource(Res.string.login_field)) },
            placeholder = { Text(stringResource(Res.string.name_placeholder)) },
            maxLines = 1
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(24.dp),
            label = { Text(stringResource(Res.string.password_field)) },
            placeholder = { stringResource(Res.string.password_placeholder) },
            maxLines = 1
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 32.dp)
        ) {
            Text(
                stringResource(Res.string.login_button),
                fontSize = 24.sp
            )

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                stringResource(Res.string.registration_text),
                color = Color.White,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            )

            TextButton(
                {},
            ) {
                Text(
                    stringResource(Res.string.registration_button),
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
