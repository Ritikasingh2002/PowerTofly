package com.hackygirls.kavachh.couroutines

import com.hackygirls.kavachh.dataClass.LendrProfile
import okhttp3.Cookie
import retrofit2.Response

class Repository {
    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }
    suspend fun getPost(): Response<LendrProfile> {
        return ProfInstance.api.getPost()
    }
}