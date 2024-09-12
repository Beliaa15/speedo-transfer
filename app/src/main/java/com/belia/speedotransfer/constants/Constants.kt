package com.belia.speedotransfer.constants

object Constants {
    // Waiting for BE team to send userId and deploy
    const val BASE_URL = "http://10.0.2.2:3000/"
    const val LOGIN_ENDPOINT = "api/v1/auth/login"
    const val REGISTER_ENDPOINT = "api/v1/auth/register"
    const val LOGOUT_ENDPOINT = "api/v1/auth/logout"
    const val USER_ENDPOINT = "api/v1/account/{customerId}"
    const val CHANGE_PASSWORD_ENDPOINT = "/api/v1/customers/password/{customerId}"
    const val EDIT_PROFILE_ENDPOINT = "/api/v1/customers/data/{customerId}"
    const val CREATE_FAVOURITE_ENDPOINT = "/api/v1/favourites/{accountNumber}"
    const val DELETE_FAVOURITE_ENDPOINT = "/api/v1/favourites/{accountNumber}"
    const val GET_FAVOURITES_ENDPOINT = "/api/v1/favourites/{customerId}"
    const val TRANSFER_ENDPOINT = "/api/v1/account/transfer"
}