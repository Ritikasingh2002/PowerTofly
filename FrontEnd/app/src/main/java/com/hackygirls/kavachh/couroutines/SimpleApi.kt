package com.hackygirls.kavachh.couroutines

import com.hackygirls.kavachh.dataClass.LendrProfile
import com.hackygirls.kavachh.dataClass.Signup
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SimpleApi {
    @POST("Register/Lender/")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
    @GET("Profile")
    suspend fun getPost(
//        @Header("Cookie")
//        COOKIE: String = "u56tlr0dwc7o5oht6rdndwcmm4nlbh26"
    ): Response<LendrProfile>
}