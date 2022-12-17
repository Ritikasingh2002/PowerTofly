package com.hackygirls.kavachh.transactions

import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.dataClass.recenctTrans
import retrofit2.Response
import retrofit2.http.GET

interface TrnsacApi {
    @GET("Payment/TransactionHistory/")
    suspend fun getPost(): Response<Trnsactns>
}