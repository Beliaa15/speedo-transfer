package com.belia.speedotransfer.model

data class Transactor(
    val name: String,
    val accountNumber: String,
)

data class Transaction (
    val id: Int,
    val sender: Transactor,
    val recipient: Transactor,
    val amount: Float,
    val createdAt: String,
    val success: Boolean,
)