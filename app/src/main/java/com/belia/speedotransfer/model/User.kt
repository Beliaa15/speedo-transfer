package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id") val id: String = "0",
    @SerializedName("name") val name: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("country") val country: String = "",
    @SerializedName("dateOfBirth") val dob: String = "",
    @SerializedName("accounts") val accounts: List<Account> = emptyList(),
    val account: Account = Account()
)
