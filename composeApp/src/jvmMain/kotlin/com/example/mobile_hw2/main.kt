package com.example.mobile_hw2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Mobilehw2",
    ) {
        App()
    }
}