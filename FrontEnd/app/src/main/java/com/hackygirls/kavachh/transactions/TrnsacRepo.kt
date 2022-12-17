package com.hackygirls.kavachh.transactions

import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.dataClass.recenctTrans
import retrofit2.Response

class TrnsacRepo {
    suspend fun getPost(): Response<Trnsactns> {
        return RetrofitInstanceeee.api.getPost()
    }

}