package com.hackygirls.kavachh.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.RazorpayActivity
import com.hackygirls.kavachh.databinding.ActivityBorrowerBinding.inflate
import com.hackygirls.kavachh.databinding.FragmentLendersWalletBinding
import java.util.zip.Inflater

class LendersWalletFragment : Fragment() {
    private lateinit var  binding : FragmentLendersWalletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLendersWalletBinding.inflate(layoutInflater)
        binding.ac.setOnClickListener {
            val intent = Intent (getActivity(), RazorpayActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        binding.upi.setOnClickListener {
            val intent = Intent (getActivity(), RazorpayActivity::class.java)
            getActivity()?.startActivity(intent)
        }
        return binding.root
    }


}