package com.hackygirls.kavachh.couroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.RegisterCoroutines.Repoo

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}