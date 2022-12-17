package com.hackygirls.kavachh.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackygirls.kavachh.dataClass.signres
import com.hackygirls.kavachh.repo.LoginRepo
import com.hackygirls.kavachh.repo.SignupRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
        private val repoInstance = LoginRepo()
    lateinit var signupResponse : Call<signres>
    val login = MutableLiveData<signres>()

    fun login (email:String , password:String):MutableLiveData<signres> {
        this.signupResponse = repoInstance.login(email, password)

        signupResponse.enqueue(object : Callback<signres> {
            override fun onResponse(call: Call<signres>, response: Response<signres>) {
                login.value =  response.body()
                Log.d("response", response.body().toString())
            }
            @SuppressLint("LogNotTimber")
            override fun onFailure(call: Call<signres>, t: Throwable) {
                Log.d("batao", "Error in fetching: $t")
            }

        })
        return login
    }
}