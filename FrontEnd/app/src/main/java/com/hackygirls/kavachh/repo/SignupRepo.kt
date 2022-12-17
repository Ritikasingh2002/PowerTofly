package com.hackygirls.kavachh.repo

import android.app.Application
import com.hackygirls.kavachh.`interface`.SignupInterface
import com.hackygirls.kavachh.`interface`.SignupService
import com.hackygirls.kavachh.dataClass.Signup
import com.hackygirls.kavachh.dataClass.Signup2
import com.hackygirls.kavachh.dataClass.signres
import com.hackygirls.kavachh.util.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupRepo constructor (val application: Application) {
    val localKeyStorage: SessionManager = SessionManager(application)
    fun signup(email: String,
                 password: String,
                 username: String):Call<Signup> {
        return SignupService.signupInstance.signup(Signup(email, password, username))
    }
    fun crProfile(  account_number: String,
                    contact_no: String,
                    first_name: String,
                    last_name: String,
                    upi_id: String) : Call<Signup2> {
        return SignupService.signupInstance.crProfile(Signup2(account_number, contact_no, first_name, last_name, upi_id))
    }
}