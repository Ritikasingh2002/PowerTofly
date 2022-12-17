package com.hackygirls.kavachh.Login

import com.hackygirls.kavachh.dataClass.Login
import retrofit2.Response
import retrofit2.http.*

interface LoginApi {

    @POST("Login/Lender/")
    suspend fun pushPost(
//        @Header("Authorization") auth: String = "Basic",
//        auth: String,
        @Body post: Login
    ): Response<Login>
}