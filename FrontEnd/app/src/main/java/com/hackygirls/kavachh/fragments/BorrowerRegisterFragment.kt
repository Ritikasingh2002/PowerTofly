package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.databinding.FragmentBorrowerRegisterBinding

class BorrowerRegisterFragment : Fragment() {

    companion object {
        @JvmStatic val fragment = BorrowerRegisterFragment()
    }
    private lateinit var binding : FragmentBorrowerRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBorrowerRegisterBinding.inflate(layoutInflater)
        binding.register.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("username",binding.usernameInput.text.toString())
            bundle.putString("email",binding.emailInput.text.toString())
            bundle.putString("password",binding.passwordInput.text.toString())
            findNavController().navigate(R.id.action_borrowerRegisterFragment_to_borroweRegister2Fragment, bundle)
          //  findNavController().navigate(R.id.borroweRegister2Fragment,bundle)
        }
        return binding.root
    }


}