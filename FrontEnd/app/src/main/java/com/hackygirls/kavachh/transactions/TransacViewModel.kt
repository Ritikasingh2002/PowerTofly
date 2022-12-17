package com.hackygirls.kavachh.transactions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackygirls.kavachh.dataClass.Trnsactns
import kotlinx.coroutines.launch
import retrofit2.Response

class TransacViewModel(private val repository: TrnsacRepo): ViewModel() {
    var myResponse: MutableLiveData<Response<Trnsactns>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}