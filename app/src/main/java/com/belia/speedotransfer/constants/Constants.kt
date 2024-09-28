package com.belia.speedotransfer.constants

object Constants {
    // Waiting for BE team to send userId and deploy
    const val BASE_URL = "https://speedo-api.vercel.app/"
    //const val BASE_URL = "http://10.0.2.2:3000/api/v1/"
    const val LOGIN_ENDPOINT = "auth/login"
    const val REGISTER_ENDPOINT = "auth/register"
    const val LOGOUT_ENDPOINT = "auth/logout"
    const val USER_ENDPOINT = "user/getUser"
    const val CHANGE_PASSWORD_ENDPOINT = "customers/password/{customerId}"
    const val EDIT_PROFILE_ENDPOINT = "customers/data/{customerId}"
    const val CREATE_FAVOURITE_ENDPOINT = "favourites/{accountNumber}"
    const val DELETE_FAVOURITE_ENDPOINT = "favourites/{accountNumber}"
    const val GET_FAVOURITES_ENDPOINT = "favourites/{customerId}"
    const val TRANSFER_ENDPOINT = "account/transfer"
}