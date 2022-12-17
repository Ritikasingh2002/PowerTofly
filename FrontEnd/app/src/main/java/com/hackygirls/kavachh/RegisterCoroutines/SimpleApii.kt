package com.hackygirls.kavachh.RegisterCoroutines

import com.hackygirls.kavachh.couroutines.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SimpleApii {
    @POST("Register/Borrower/")
    suspend fun pushPost(
        @Body post: BRegister
    ): Response<BRegister>
}