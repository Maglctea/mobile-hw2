package com.example.mobile_hw2

import com.example.mobile_hw2.navigation.CoursesRoute
import com.example.mobile_hw2.navigation.LoginRoute
import com.example.mobile_hw2.navigation.WelcomeRoute
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
import com.example.mobile_hw2.auth.LoginScreen
import com.example.mobile_hw2.course.CoursesScreen
import com.example.mobile_hw2.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    AppTheme {
        NavHost(
            navController = navController,
            startDestination = WelcomeRoute,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding()
        ) {
            composable<WelcomeRoute> {
                WelcomeScreen(onToLogin = { navController.navigate(LoginRoute) })
            }
            composable<LoginRoute> {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(CoursesRoute) {
                            popUpTo(WelcomeRoute) { inclusive = true }
                        }
                    }
                )
            }
            composable<CoursesRoute> {
                CoursesScreen()
            }
        }
    }
}