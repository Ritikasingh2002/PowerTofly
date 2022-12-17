package com.hackygirls.kavachh.Login

import com.hackygirls.kavachh.dataClass.Login
import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.transactions.RetrofitInstanceeee
import retrofit2.Response

class LoginRepo {
    suspend fun pushPost(response: Login): Response<Login> {
        return Instance.api.pushPost(response)
    }
}