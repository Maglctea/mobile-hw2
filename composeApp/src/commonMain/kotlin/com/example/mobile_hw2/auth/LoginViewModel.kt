package com.example.mobile_hw2.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    private val _loginSuccess = MutableSharedFlow<Unit>()
    val loginSuccess = _loginSuccess.asSharedFlow()

    fun onEmailChange(value: String) {
        _uiState.update { it.copy(email = value) }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { it.copy(password = value) }
    }

    fun login() {
        viewModelScope.launch {
            val state = uiState.value
            if (!state.isLoginButtonActive) {
                _uiState.update { it.copy(error = LoginError.EmptyCredentials) }
                return@launch
            }
            try {
                authRepository.login(state.email, state.password)
                _uiState.update { it.copy(error = null) }
                _loginSuccess.emit(Unit)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = LoginError.NetworkError(e.message)) }
            }
        }
    }
}