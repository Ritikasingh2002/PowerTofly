package com.hackygirls.kavachh.transactions

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstanceeee {
    private var  base_url = "https://kavach-amex.herokuapp.com/KavachAuth/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TrnsacApi by lazy {
        retrofit.create(TrnsacApi::class.java)
    }
}