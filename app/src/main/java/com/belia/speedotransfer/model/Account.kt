package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName

data class Account (
    val id: Int = 0,
    val accountNumber: String = "",
    val accountType: String = "", // You might want to define an enum for account types
    val balance: Double = 0.0,
    val active: Boolean = true,
    val createdAt: String = "",
    val transactions: List<Transaction> = emptyList(),
    val updatedAt: String = ""
)

data class ChangePasswordRequest (
    val oldPassword: String,
    val newPassword: String,
)

data class EditProfileRequest (
    @SerializedName("userId")
    val id: String,
    val updateDate : String = "",
    val name: String,
    val email: String,
    val country: String,
    @SerializedName("dateOfBirth")
    val dob: String = "",
)

data class Message(
    val message: String,
)