package com.hackygirls.kavachh.userProfile

import com.hackygirls.kavachh.couroutines.Interceptor
import com.hackygirls.kavachh.couroutines.SimpleApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SspctInterface {
    private var  base_url = "https://kavach-amex.herokuapp.com/Payment/"
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

    val api: SusApi by lazy {
        retrofit.create(SusApi::class.java)
    }
}