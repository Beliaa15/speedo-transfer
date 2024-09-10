package com.belia.speedotransfer.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val userId: Int,
    val userName: String,
    val message: String
)

data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val dateOfBirth: String,
    val country: String
)