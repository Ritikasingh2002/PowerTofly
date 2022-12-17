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
import com.hackygirls.kavachh.adapters.SuspectAdapter
import com.hackygirls.kavachh.dataClass.SuspectX
import com.hackygirls.kavachh.databinding.FragmentSuspectListBinding
import com.hackygirls.kavachh.userProfile.SLisRepo
import com.hackygirls.kavachh.userProfile.SscptViewModelFactory
import com.hackygirls.kavachh.userProfile.SuspectViewModel

class SuspectListFragment : Fragment() {

    private lateinit var binding : FragmentSuspectListBinding
    private lateinit var viewModel : SuspectViewModel
    private val susAdapter:SuspectAdapter by lazy{SuspectAdapter()}
//    private val list : MutableList<Suspect> =

    // val rView : RecyclerView = trview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSuspectListBinding.inflate(layoutInflater)
//        rView.layoutManager = LinearLayoutManager(context)
//        val data = ArrayList<Suspect>()
//        data.add(
//            Suspect( "200", "AmexDemo_Borrower", "2022-04-06T00:07:52.478", "A")
//        )
//        val adapter = SuspectAdapter(data)
//        rView.adapter = adapter

        val repository = SLisRepo()
        val viewModelFactory = SscptViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(SuspectViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(requireActivity(), Observer { response ->


            if(response.isSuccessful){
                response.body()?.suspect_list?.let { susAdapter.setSuspct(it) }
                Log.e("Suspectlist", response.body()?.suspect_list.toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())



//                binding.acname.text = response.body()?.first_name.toString()
//                binding.acno.text = response.body()?.account_number.toString()
//                binding.upi.text = response.body()?.upi_id.toString()
//                binding.email.text = response.body()?.email.toString()
            }else {
                Log.e("DATA","DATA nhi aara")
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
        binding.recView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.recView.adapter = susAdapter

        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_suspectListFragment_to_lenderFragment)
        }
        return binding.root

    }


}