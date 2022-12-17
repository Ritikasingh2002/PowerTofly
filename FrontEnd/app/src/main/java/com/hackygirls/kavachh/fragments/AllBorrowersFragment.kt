package com.hackygirls.kavachh.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.adapters.BorrowersAdapter
import com.hackygirls.kavachh.adapters.TransactionsHCAdapter
import com.hackygirls.kavachh.couroutines.ProfileViewModel
import com.hackygirls.kavachh.couroutines.ProfileViewModelFactory
import com.hackygirls.kavachh.couroutines.Repository
import com.hackygirls.kavachh.dataClass.Brrwrs
import com.hackygirls.kavachh.dataClass.recenctTrans
import com.hackygirls.kavachh.databinding.FragmentAllBorrowersBinding
import com.hackygirls.kavachh.userProfile.SLisRepo
import com.hackygirls.kavachh.userProfile.SscptViewModelFactory
import com.hackygirls.kavachh.userProfile.SuspectViewModel
import com.hackygirls.kavachh.viewModel.viewModelFactory
import kotlinx.android.synthetic.main.fragment_all_borrowers.*

class AllBorrowersFragment : Fragment() {
   private lateinit var binding : FragmentAllBorrowersBinding


   // val rView : RecyclerView = trview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllBorrowersBinding.inflate(layoutInflater)

//        rView.layoutManager = LinearLayoutManager(context)
//        val data = ArrayList<Brrwrs>()
//
//        data.add(
//            Brrwrs("Amex Amex", "AmexDemo_Borrower", "A" )
//        )
//        val adapter = BorrowersAdapter(data)
//        rView.adapter = adapter


        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_allBorrowersFragment_to_lenderFragment)
        }
        return binding.root

    }

}