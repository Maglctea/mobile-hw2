package com.example.mobile_hw2.auth

import com.example.mobile_hw2.network.NetworkClient

class AuthRepositoryImpl : AuthRepository {
    private val api: AuthApi = NetworkClient.retrofit.create(AuthApi::class.java)

    override suspend fun login(email: String, password: String): UserDto {
        val response = api.login(LoginRequest(email, password))
        return response.data
    }

    override suspend fun logout() {
        api.logout()
    }
}