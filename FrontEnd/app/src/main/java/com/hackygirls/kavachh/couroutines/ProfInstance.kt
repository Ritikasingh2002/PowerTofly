package com.hackygirls.kavachh.couroutines

import com.hackygirls.kavachh.Login.MyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProfInstance {
    private var  base_url = "https://kavach-amex.herokuapp.com/Lender/"
//    private var sampleToken = "u56tlr0dwc7o5oht6rdndwcmm4nlbh26"
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(Interceptor())
    }.build()
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}