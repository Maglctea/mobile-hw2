package com.example.mobile_hw2.auth

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("api/v2.user.login")
    suspend fun login(@Body body: LoginRequest): ApiResponse<UserDto>

    @POST("api/v2.user.logout")
    suspend fun logout(): ApiResponse<Unit>
}