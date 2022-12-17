package com.hackygirls.kavachh.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackygirls.kavachh.dataClass.signres
import com.hackygirls.kavachh.repo.RegBrwrRepo
import com.hackygirls.kavachh.repo.SignupRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BorrowerViewModel : ViewModel() {
    private val repoInstance = RegBrwrRepo()
    lateinit var signupResponse : Call<signres>
    val signup = MutableLiveData<signres>()

    fun borrower(
        email: String,
        password: String,
        username: String): MutableLiveData<signres> {
        this.signupResponse = repoInstance.regbrwr(email,password, username)
        signupResponse.enqueue(object : Callback<signres> {
            override fun onResponse(call: Call<signres>, response: Response<signres>) {
                signup.value =  response.body()
                Log.d("response", response.body().toString())
            }
            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<signres>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }

        })
        return signup
    }

    fun brProfile(
        account_number: String,
        contact_no: String,
        first_name: String,
        last_name: String
    ): MutableLiveData<signres> {
        this.signupResponse = repoInstance.brProfile(account_number, contact_no, first_name, last_name)
        signupResponse.enqueue(object : Callback<signres>{
            override fun onResponse(call: Call<signres>, response: Response<signres>) {
                signup.value =  response.body()
                Log.d("response", response.body().toString())
            }
            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<signres>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }
        })
        return signup
    }
}