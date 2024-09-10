package com.belia.speedotransfer.model

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