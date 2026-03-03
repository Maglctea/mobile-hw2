package com.example.mobile_hw2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.mobile_hw2.config.AppConfig
import mobilehw2.composeapp.generated.resources.Res
import mobilehw2.composeapp.generated.resources.logo
import mobilehw2.composeapp.generated.resources.welcome_logo_placeholder
import mobilehw2.composeapp.generated.resources.welcome_start_button
import mobilehw2.composeapp.generated.resources.welcome_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun WelcomeScreen(onToLogin: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
    ) {

        AsyncImage(
            model = AppConfig.WELCOME_ICON_URL,
            contentDescription = stringResource(Res.string.welcome_logo_placeholder),
            placeholder = painterResource(Res.drawable.logo)
        )
        Text(
            stringResource(Res.string.welcome_title),
            color = Color.White,
            fontSize = 32.sp,
            lineHeight = 48.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = onToLogin,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 32.dp)
        ) {
            Text(
                stringResource(Res.string.welcome_start_button),
                fontSize = 24.sp
            )

        }
    }

}