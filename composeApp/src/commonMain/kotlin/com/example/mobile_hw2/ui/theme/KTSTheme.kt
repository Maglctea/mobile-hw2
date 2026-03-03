package com.example.mobile_hw2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NeonGreen = Color(0xFF39FF14)
private val NearBlack = Color(0xFF050505)
private val DarkSurface = Color(0xFF0E0E0E)

private val KtsNeonDarkScheme = darkColorScheme(
    primary = NeonGreen,
    onPrimary = NearBlack,

    background = NearBlack,
    onBackground = Color.White,

    surface = DarkSurface,
    onSurface = Color.White,

    primaryContainer = Color(0xFF102A10),
    onPrimaryContainer = NeonGreen
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = KtsNeonDarkScheme,
        content = content
    )
}