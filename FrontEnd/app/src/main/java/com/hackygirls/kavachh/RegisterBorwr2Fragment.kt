package com.hackygirls.kavachh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hackygirls.kavachh.RegisterCoroutines.BRegister
import com.hackygirls.kavachh.RegisterCoroutines.MainViewModel
import com.hackygirls.kavachh.RegisterCoroutines.MainViewModelFactory
import com.hackygirls.kavachh.RegisterCoroutines.Repoo
import com.hackygirls.kavachh.databinding.FragmentRegisterBorwr2Binding

class RegisterBorwr2Fragment : Fragment() {

    private lateinit var binding : FragmentRegisterBorwr2Binding
    private lateinit var viewModel: MainViewModel
    var accno = binding.accnoInput.text.toString()
    var cno = binding.cnoInput.text.toString()
    var fname = binding.fnameInput.text.toString()
    var lname = binding.lnameInput.text.toString()
    var bundle = this.arguments
    var username = bundle?.getString("username").toString()
    var email =    bundle?.getString("email").toString()
    var pass =     bundle?.getString("password").toString()
    var add1 = binding.addInput.text.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBorwr2Binding.inflate(layoutInflater)

        var repository = Repoo()
        var viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //  var bundle = this.arguments

        binding.register.setOnClickListener {
//            viewModel.pushPost(BRegister(accno,cno,email, fname,  lname, pass, username, add1))
//            viewModel.myResponse.observe(requireActivity(), Observer { response ->
//                if(response.isSuccessful){
//
//                    Log.d("Main", response.body().toString())
//                    Log.d("Main", response.code().toString())
//                    Log.d("Main", response.message())
//                    val i  = Intent(requireContext(), MainActivity::class.java)
//                    startActivity(i)
//
//                }else {
////                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//                }
//            })
            val i  = Intent(requireContext(), MainActivity::class.java)
                    startActivity(i)
        }
        return binding.root
    }

}