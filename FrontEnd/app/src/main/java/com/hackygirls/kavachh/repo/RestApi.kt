package com.hackygirls.kavachh.repo

import com.hackygirls.kavachh.`interface`.ServiceBuilder
import com.hackygirls.kavachh.`interface`.SignupInterface
import com.hackygirls.kavachh.`interface`.SignupService
import com.hackygirls.kavachh.dataClass.Signup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApi {
    fun addUser(userData: Signup, onResult: (Signup?) -> Unit){
        val retrofit = ServiceBuilder.buildService(SignupInterface::class.java)
       retrofit.signup(userData).enqueue( object : Callback<Signup> {
           override fun onFailure(call: Call<Signup>, t: Throwable) {
               onResult(null)
           }
           override fun onResponse( call: Call<Signup>, response: Response<Signup>) {
               val addedUser = response.body()
               onResult(addedUser)
           }
       })
    }
}