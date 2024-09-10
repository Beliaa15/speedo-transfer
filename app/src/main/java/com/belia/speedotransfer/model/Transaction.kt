package com.belia.speedotransfer.model

data class Transaction (
    val id: Int,
    val sender: Account,
    val recipient: Account,
    val amount: Float,

)