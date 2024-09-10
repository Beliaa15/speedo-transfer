package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val country: String = "",
    @SerializedName("dateofBirth")
    val dob: String = "",
    val account: Account = Account()
)
