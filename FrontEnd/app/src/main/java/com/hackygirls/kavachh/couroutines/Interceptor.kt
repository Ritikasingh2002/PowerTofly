package com.hackygirls.kavachh.couroutines

import okhttp3.Interceptor

class Interceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Cookie", "sessionid=dmgjvrb11tezf8yr1goauaih2v6n0h71").build()

        return chain.proceed(request)
    }
}