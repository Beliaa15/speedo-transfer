package com.belia.speedotransfer.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val country: String,
    @SerializedName("dateofBirth")
    val dob: String
)
