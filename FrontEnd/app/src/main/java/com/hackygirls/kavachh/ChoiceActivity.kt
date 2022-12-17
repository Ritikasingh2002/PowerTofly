package com.hackygirls.kavachh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hackygirls.kavachh.databinding.ActivityChoiceBinding

class ChoiceActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_choice)
        binding.lender.setOnClickListener {
            val i  = Intent(this,VolleyLoginActivity::class.java)
            startActivity(i)
            finish()
        }
        binding.borrower.setOnClickListener {
            val i  = Intent(this,BorrowerLogin::class.java)
            startActivity(i)
            finish()
        }
    }
}