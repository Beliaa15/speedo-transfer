package com.belia.speedotransfer.api

import com.belia.speedotransfer.constants.Constants.CHANGE_PASSWORD_ENDPOINT
import com.belia.speedotransfer.constants.Constants.CREATE_FAVOURITE_ENDPOINT
import com.belia.speedotransfer.constants.Constants.DELETE_FAVOURITE_ENDPOINT
import com.belia.speedotransfer.constants.Constants.EDIT_PROFILE_ENDPOINT
import com.belia.speedotransfer.constants.Constants.GET_FAVOURITES_ENDPOINT
import com.belia.speedotransfer.constants.Constants.LOGIN_ENDPOINT
import com.belia.speedotransfer.constants.Constants.LOGOUT_ENDPOINT
import com.belia.speedotransfer.constants.Constants.REGISTER_ENDPOINT
import com.belia.speedotransfer.constants.Constants.TRANSFER_ENDPOINT
import com.belia.speedotransfer.constants.Constants.USER_ENDPOINT
import com.belia.speedotransfer.model.ChangePasswordRequest
import com.belia.speedotransfer.model.EditProfileRequest
import com.belia.speedotransfer.model.Favourite
import com.belia.speedotransfer.model.LoginRequest
import com.belia.speedotransfer.model.LoginResponse
import com.belia.speedotransfer.model.SignUpRequest
import com.belia.speedotransfer.model.TransferRequest
import com.belia.speedotransfer.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface APICallable {

    @POST(LOGIN_ENDPOINT)
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST(REGISTER_ENDPOINT)
    suspend fun register(@Body signUpRequest: SignUpRequest): User

    @POST(LOGOUT_ENDPOINT)
    suspend fun logout()

    @GET(USER_ENDPOINT)
    suspend fun getUser(@Header("token") token: String, @Path("customerId") customerId: Int): User

    @POST(CHANGE_PASSWORD_ENDPOINT)
    suspend fun changePassword(
        @Path("customerId") customerId: Int,
        @Body changePasswordRequest: ChangePasswordRequest
    ): User

    @POST(EDIT_PROFILE_ENDPOINT)
    suspend fun editProfile(
        @Path("customerId") customerId: Int,
        @Body editProfileRequest: EditProfileRequest
    ): User

    @POST(CREATE_FAVOURITE_ENDPOINT)
    suspend fun createFavourite(
        @Path("accountNumber") accountNumber: String,
        @Body fav: Favourite
    ): Favourite

    @POST(DELETE_FAVOURITE_ENDPOINT)
    suspend fun removeFavourite(
        @Path("accountNumber") accountNumber: String,
        @Body fav: Favourite
    ): Favourite

    @GET(GET_FAVOURITES_ENDPOINT)
    suspend fun getFavourites(
        @Path("customerId") customerId: Int
    ): List<Favourite>

    @POST(TRANSFER_ENDPOINT)
    suspend fun transferMoney(
        @Body transferRequest: TransferRequest
    ): String
}