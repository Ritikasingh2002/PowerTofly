package com.hackygirls.kavachh.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackygirls.kavachh.dataClass.Signup
import com.hackygirls.kavachh.dataClass.Signup2
import com.hackygirls.kavachh.dataClass.signres
import com.hackygirls.kavachh.repo.SignupRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupViewModel(application: Application):AndroidViewModel(application) {
    private val repoInstance = SignupRepo(application)
    lateinit var signupResponse : Call<Signup>
    lateinit var profResponse: Call<Signup2>
    val signup = MutableLiveData<Signup>()
    val crprof = MutableLiveData<Signup2>()

    fun signuser(
                  email: String,
                  password: String,
                  username: String):MutableLiveData<Signup>{
        this.signupResponse = repoInstance.signup( email, password, username)
        signupResponse.enqueue(object : Callback<Signup> {
            override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                signup.value =  response.body()
                Log.d("response", response.body().toString())
            }
            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<Signup>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }

        })
        return signup
    }
    fun crProfile(
        account_number: String,
        contact_no: String,
        first_name: String,
        last_name: String,
        upi_id: String
    ):MutableLiveData<Signup2>{
        this.profResponse = repoInstance.crProfile(account_number, contact_no, first_name, last_name, upi_id)
        profResponse.enqueue(object : Callback<Signup2>{
            override fun onResponse(call: Call<Signup2>, response: Response<Signup2>) {
                crprof.value =  response.body()
                Log.d("response", response.body().toString())
            }
            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<Signup2>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }
        })
        return crprof
    }
}