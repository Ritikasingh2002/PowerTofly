package com.hackygirls.kavachh.couroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackygirls.kavachh.dataClass.LendrProfile
import kotlinx.coroutines.launch
import okhttp3.Cookie
import retrofit2.Response

class ProfileViewModel (private val repository: Repository): ViewModel() {
    var myResponse: MutableLiveData<Response<LendrProfile>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}