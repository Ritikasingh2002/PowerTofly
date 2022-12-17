 package com.hackygirls.kavachh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.hackygirls.kavachh.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

     private lateinit var binding : ActivityMainBinding
     private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.NavHostFragment) as NavHostFragment
    }
}