package com.hackygirls.kavachh.RegisterCoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: Repoo): ViewModel(){
    var myResponse: MutableLiveData<Response<BRegister>> = MutableLiveData()

    fun pushPost(post: BRegister) {
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}