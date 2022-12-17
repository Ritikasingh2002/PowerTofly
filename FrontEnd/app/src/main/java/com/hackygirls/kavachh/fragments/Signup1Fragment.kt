package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.databinding.FragmentSignup1Binding

class Signup1Fragment : Fragment() {
    private lateinit var binding : FragmentSignup1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignup1Binding.inflate(layoutInflater)
        binding.register.setOnClickListener {
//            val action = Signup1FragmentDirections.actionSignup1FragmentToSignup2Fragment().setEmail(binding.emailInput.toString())
//            val action2 = Signup1FragmentDirections.actionSignup1FragmentToSignup2Fragment().setUsername(binding.usernameInput.toString())
//            val action3 = Signup1FragmentDirections.actionSignup1FragmentToSignup2Fragment().setPassword(binding.passwordInput.toString())
            var bundle = Bundle()
            bundle.putString("username",binding.usernameInput.text.toString())
            bundle.putString("email",binding.emailInput.text.toString())
            bundle.putString("password",binding.passwordInput.text.toString())
            findNavController().navigate(R.id.action_signup1Fragment_to_signup2Fragment,bundle)
        }
        return binding.root
    }


}