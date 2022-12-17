package com.hackygirls.kavachh.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.databinding.FragmentPendingReqBinding

class PendingReqFragment : Fragment() {
    private lateinit var binding : FragmentPendingReqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPendingReqBinding.inflate(layoutInflater)
        binding.mov.setOnClickListener {
            findNavController().navigate(R.id.action_pendingReqFragment_to_enterRangeFragment)
        }
        binding.rtr.setOnClickListener {
            findNavController().navigate(R.id.action_pendingReqFragment_to_enterRangeFragment)
        }
        binding.bck2.setOnClickListener {
            findNavController().navigate(R.id.action_pendingReqFragment_to_lenderFragment)
        }
        return binding.root
    }



}