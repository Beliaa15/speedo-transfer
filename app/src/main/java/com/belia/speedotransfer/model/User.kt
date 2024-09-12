package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val country: String = "",
    @SerializedName("dateOfBirth")
    val dob: String = "",
    @SerializedName("mainAccount")
    val account: Account = Account()
)
