package com.hackygirls.kavachh.Login

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor(username: String, password : String):Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request().newBuilder().addHeader("Authorization","Basic").build()
//        return chain.proceed(request)
//    }
private var credentials: String = Credentials.basic(username, password)

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", credentials).build()
        return chain.proceed(request)
    }

}