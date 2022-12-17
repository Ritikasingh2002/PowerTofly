package com.hackygirls.kavachh.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.`interface`.SignupInterface
import com.hackygirls.kavachh.repo.SignupRepo

class viewModelFactory {
    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModelFactory() as T
        }
    }
}