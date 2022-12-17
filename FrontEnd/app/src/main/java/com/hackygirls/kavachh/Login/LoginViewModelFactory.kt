package com.hackygirls.kavachh.Login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.transactions.TrnsacRepo

class LoginViewModelFactory (private val repository: LoginRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}