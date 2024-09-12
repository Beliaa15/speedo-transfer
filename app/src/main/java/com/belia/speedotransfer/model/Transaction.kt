package com.belia.speedotransfer.model


data class Transaction (
    val senderAccount: String,
    val recipientAccount: String,
    val senderName: String,
    val recipientName: String,
    val amount: Float,
    val createdAt: String,
    val success: Boolean,
)