package com.example.mobile_hw2.auth

sealed class LoginError {
    data object EmptyCredentials : LoginError()
    data class NetworkError(val message: String?) : LoginError()
}

data class LoginState(
    val email: String = "",
    val password: String = "",
    val error: LoginError? = null,
) {
    val isLoginButtonActive: Boolean
        get() = email.isNotEmpty() && password.isNotEmpty()
}
