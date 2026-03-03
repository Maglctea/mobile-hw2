package com.example.mobile_hw2.auth

interface AuthRepository {
    suspend fun login(email: String, password: String): UserDto
    suspend fun logout()
}
