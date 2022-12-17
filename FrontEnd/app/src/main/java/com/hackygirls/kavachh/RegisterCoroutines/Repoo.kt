package com.hackygirls.kavachh.RegisterCoroutines

import com.hackygirls.kavachh.couroutines.Post
import com.hackygirls.kavachh.couroutines.RetrofitInstance
import retrofit2.Response

class Repoo {
    suspend fun pushPost(post: BRegister): Response<BRegister> {
        return RetroInstance.api.pushPost(post)
    }
}