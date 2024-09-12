package com.belia.speedotransfer.api

import com.belia.speedotransfer.constants.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: APICallable by lazy {
        retrofit.create(APICallable::class.java)
    }
}