package com.hackygirls.kavachh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.databinding.FragmentRegisterBorwrBinding

class RegisterBorwrFragment : Fragment() {
   private lateinit var binding : FragmentRegisterBorwrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBorwrBinding.inflate(layoutInflater)
//        binding.register.setOnClickListener {
////            var bundle = Bundle()
////            bundle.putString("username",binding.usernameInput.text.toString())
////            bundle.putString("email",binding.emailInput.text.toString())
////            bundle.putString("password",binding.passwordInput.text.toString())
//            findNavController().navigate(R.id.action_registerBorwrFragment_to_registerBorwr2Fragment)
//            //  findNavController().navigate(R.id.borroweRegister2Fragment,bundle)
//        }
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_registerBorwrFragment_to_registerBorwr2Fragment)
        }
        return binding.root
    }

}