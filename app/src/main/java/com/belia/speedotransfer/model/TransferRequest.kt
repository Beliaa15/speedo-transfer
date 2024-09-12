package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class TransferRequest(
    @SerializedName("fromAccount")
    val senderAccount: String,
    @SerializedName("toAccount")
    val recipientAccount: String,
    val amount: BigDecimal
)
