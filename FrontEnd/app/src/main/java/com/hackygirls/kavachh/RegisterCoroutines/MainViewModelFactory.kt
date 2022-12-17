package com.hackygirls.kavachh.RegisterCoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.couroutines.MainViewModel
import com.hackygirls.kavachh.couroutines.Repository

class MainViewModelFactory (private val repository: Repoo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}