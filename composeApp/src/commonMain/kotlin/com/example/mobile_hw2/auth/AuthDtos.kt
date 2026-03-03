package com.example.mobile_hw2.auth

data class ApiResponse<T>(
    val status: String,
    val data: T
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class UserDto(
    val id: Long,
    val phone: String?,
    val email: String,
    val first_name: String,
    val last_name: String,
    val companies: List<CompanyDto>,
    val type: String
)

data class CompanyDto(
    val name: String,
    val id: Long,
    val role: String
)