package com.belia.speedotransfer.model

import java.time.LocalDateTime

data class Account (
    val id: Int,
    val accountNumber: String,
    val accountType: String, // You might want to define an enum for account types
    val balance: Double,
    val active: Boolean,
    val createdAt: LocalDateTime,
    val transactions: List<Transaction>,
    val updatedAt: LocalDateTime
)