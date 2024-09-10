package com.belia.speedotransfer.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("http://10.0.2.2:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable: APICallable by lazy {
        retrofit.create(APICallable::class.java)
    }
}