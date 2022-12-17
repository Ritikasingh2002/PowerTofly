package com.hackygirls.kavachh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.hackygirls.kavachh.databinding.ActivityBorrowerRegistrationBinding
import com.hackygirls.kavachh.viewModel.BorrowerViewModel

class BorrowerRegistrationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBorrowerRegistrationBinding
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_borrower_registration)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.navhost_fragment) as NavHostFragment
    }
}