package com.hackygirls.kavachh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hackygirls.kavachh.databinding.ActivityBorrowerLoginBinding

class BorrowerLogin : AppCompatActivity() {
    private lateinit var binding : ActivityBorrowerLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_borrower_login)
        binding.login.setOnClickListener {
            val i  = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}