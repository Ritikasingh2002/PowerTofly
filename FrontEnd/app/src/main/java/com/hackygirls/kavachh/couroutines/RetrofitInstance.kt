package com.hackygirls.kavachh.couroutines

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitInstance {
    private var  base_url = "https://kavach-amex.herokuapp.com/KavachAuth/"
//    private var sampleToken = "dmgjvrb11tezf8yr1goauaih2v6n0h71"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}