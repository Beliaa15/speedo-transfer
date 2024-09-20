package com.belia.speedotransfer.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val userId: String,
    val message: String
)

data class SignUpRequest(
    val email: String,
    val password: String,
    val name: String,
    val country: String,
    val dateOfBirth: String,
)