package com.hackygirls.kavachh.userProfile

import com.hackygirls.kavachh.couroutines.Profile
import com.hackygirls.kavachh.dataClass.SuspectList
import com.hackygirls.kavachh.dataClass.SuspectX
import retrofit2.Response
import retrofit2.http.GET

interface SusApi {
    @GET("GetSuspectList/")
    suspend fun getPost(
//        @Header("Cookie")
//        COOKIE: String = "u56tlr0dwc7o5oht6rdndwcmm4nlbh26"
    ): Response<SuspectList>
}