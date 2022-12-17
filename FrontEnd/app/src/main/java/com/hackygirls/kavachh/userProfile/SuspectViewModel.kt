package com.hackygirls.kavachh.userProfile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackygirls.kavachh.couroutines.Profile
import com.hackygirls.kavachh.couroutines.Repository
import com.hackygirls.kavachh.dataClass.SuspectList
import com.hackygirls.kavachh.dataClass.SuspectX
import kotlinx.coroutines.launch
import retrofit2.Response

class SuspectViewModel (private val repository: SLisRepo): ViewModel() {
    var myResponse: MutableLiveData<Response<SuspectList>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
            Log.e("RESPONSE",response.toString())
        }
    }
}