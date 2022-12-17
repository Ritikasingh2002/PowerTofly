package com.hackygirls.kavachh.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hackygirls.kavachh.BorrowerRegistrationActivity
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.couroutines.MainViewModel
import com.hackygirls.kavachh.couroutines.MainViewModelFactory
import com.hackygirls.kavachh.couroutines.Post
import com.hackygirls.kavachh.couroutines.Repository
import com.hackygirls.kavachh.databinding.FragmentSignup2Binding

class Signup2Fragment : Fragment() {
    private lateinit var binding : FragmentSignup2Binding
    private lateinit var viewModel: MainViewModel

    private val args : Signup2FragmentArgs by navArgs<Signup2FragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignup2Binding.inflate(layoutInflater)
        var email = args.email.toString()
        var username = args.username.toString()
        var pass = args.password.toString()
        var accno = binding.accnoInput.text.toString()
        var cno = binding.cnoInput.text.toString()
        var fname = binding.fnameInput.text.toString()
        var lname = binding.lnameInput.text.toString()
        var upi = binding.upoInput.text.toString()
        var repository = Repository()
        var viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        var bundle = this.arguments
        if(bundle!=null){
            username = bundle.getString("username").toString()
            email =    bundle.getString("email").toString()
            pass =     bundle.getString("password").toString()
        }
        binding.register.setOnClickListener {
            viewModel.pushPost(Post(accno, cno, email, fname, lname, pass, upi, username))
            viewModel.myResponse.observe(requireActivity(), Observer { response ->
                if(response.isSuccessful){
//                    Log.d("Main", response.body().toString())
//                    Log.d("Main", response.code().toString())
//                    Log.d("Main", response.message())
                    val i  = Intent(requireContext(), BorrowerRegistrationActivity::class.java)
                    startActivity(i)
//                    findNavController().navigate(R.id.action_signup2Fragment_to_borrowerRegisterFragment2)
                }else {
//                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
                }
            })
            val i  = Intent(requireContext(), BorrowerRegistrationActivity::class.java)
            startActivity(i)

        }
//        return binding.apply {
//            val email = args.email.toString()
//            val username = args.username.toString()
//            val pass = args.password.toString()
//        }.root
        return binding.root
    }

}