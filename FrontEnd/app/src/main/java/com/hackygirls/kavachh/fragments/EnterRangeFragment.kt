package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.databinding.FragmentEnterRangeBinding

class EnterRangeFragment : Fragment() {

    private lateinit var binding: FragmentEnterRangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEnterRangeBinding.inflate(layoutInflater)
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_enterRangeFragment_to_decencyScoreFragment)
        }
        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_enterRangeFragment_to_pendingReqFragment)
        }
        return binding.root
    }


}