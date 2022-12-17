package com.hackygirls.kavachh.userProfile

import com.hackygirls.kavachh.couroutines.ProfInstance
import com.hackygirls.kavachh.couroutines.Profile
import com.hackygirls.kavachh.dataClass.SuspectList
import com.hackygirls.kavachh.dataClass.SuspectX
import retrofit2.Response

class SLisRepo {
    suspend fun getPost(): Response<SuspectList> {
        return SspctInterface.api.getPost()
    }
}