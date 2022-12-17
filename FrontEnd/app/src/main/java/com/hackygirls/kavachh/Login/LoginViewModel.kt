package com.hackygirls.kavachh.Login

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackygirls.kavachh.dataClass.Login
import com.hackygirls.kavachh.dataClass.Resource
import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.transactions.TrnsacRepo
import com.hackygirls.kavachh.util.SessionManager
import kotlinx.coroutines.launch
import retrofit2.Response


class LoginViewModel(private val repository: LoginRepo): ViewModel() {
    val TAG = "Repository"
//    var localKeyStorage: SessionManager = SessionManager(application)
    var myResponse: MutableLiveData<Response<Login>> = MutableLiveData()
    fun pushPost(resp : Login){
        viewModelScope.launch {
            val response = repository.pushPost(resp)
            myResponse.value = response

        }
    }
}