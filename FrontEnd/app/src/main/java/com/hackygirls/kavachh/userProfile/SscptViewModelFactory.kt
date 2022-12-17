package com.hackygirls.kavachh.userProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.couroutines.Repository

class SscptViewModelFactory(private val repository: SLisRepo): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SuspectViewModel(repository) as T
    }
}