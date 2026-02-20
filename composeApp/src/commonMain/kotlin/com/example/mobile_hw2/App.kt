package com.example.mobile_hw2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_hw2.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    AppTheme {

        NavHost(
            navController = navController,
            startDestination = "welcome",
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
        ) {
            composable("welcome") {
                WelcomeScreen(onToLogin = { navController.navigate("login") })
            }
            composable("login") {
                LoginScreen(onBack = { navController.navigateUp() })
            }
        }

    }
}