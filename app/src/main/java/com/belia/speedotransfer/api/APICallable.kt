package com.belia.speedotransfer.api

import com.belia.speedotransfer.constants.Constants.LOGIN_ENDPOINT
import com.belia.speedotransfer.constants.Constants.LOGOUT_ENDPOINT
import com.belia.speedotransfer.constants.Constants.REGISTER_ENDPOINT
import com.belia.speedotransfer.constants.Constants.USER_ENDPOINT
import com.belia.speedotransfer.model.LoginRequest
import com.belia.speedotransfer.model.LoginResponse
import com.belia.speedotransfer.model.SignUpRequest
import com.belia.speedotransfer.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APICallable {

    @POST(LOGIN_ENDPOINT)
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST(REGISTER_ENDPOINT)
    suspend fun register(@Body signUpRequest: SignUpRequest): User

    @POST(LOGOUT_ENDPOINT)
    suspend fun logout()

    @GET(USER_ENDPOINT)
    suspend fun getUser(@Path("customerId") customerId: Int): User

}