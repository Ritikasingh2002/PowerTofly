package com.hackygirls.kavachh.RegisterCoroutines

import com.hackygirls.kavachh.couroutines.SimpleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private var  base_url = "https://kavach-amex.herokuapp.com/KavachAuth/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApii by lazy {
        retrofit.create(SimpleApii::class.java)
    }
}