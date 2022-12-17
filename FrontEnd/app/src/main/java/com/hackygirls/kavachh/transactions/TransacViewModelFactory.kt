package com.hackygirls.kavachh.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TransacViewModelFactory (private val repository: TrnsacRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TransacViewModel(repository) as T
    }
}