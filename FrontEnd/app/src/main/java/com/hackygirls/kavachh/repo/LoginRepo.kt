package com.hackygirls.kavachh.repo

import android.app.Application
import com.hackygirls.kavachh.Login.Instance
import com.hackygirls.kavachh.`interface`.SignupService
import com.hackygirls.kavachh.dataClass.Login
import com.hackygirls.kavachh.dataClass.signres
import com.hackygirls.kavachh.util.SessionManager
import retrofit2.Call

class LoginRepo  {

    fun login(email : String, password : String) : Call<signres>{
        return SignupService.signupInstance.login(Login(email, password))
    }
}