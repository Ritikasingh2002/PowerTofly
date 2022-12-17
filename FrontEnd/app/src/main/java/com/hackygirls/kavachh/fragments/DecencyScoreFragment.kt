package com.hackygirls.kavachh.fragments


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.RazorpayActivity
import com.hackygirls.kavachh.databinding.FragmentDecencyScoreBinding
import com.mikhaellopez.circularprogressbar.CircularProgressBar


class DecencyScoreFragment : Fragment() {

    private lateinit var binding : FragmentDecencyScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDecencyScoreBinding.inflate(layoutInflater)
        binding.tomov.setOnClickListener {
            findNavController().navigate(R.id.action_decencyScoreFragment_to_mapFragment)
        }
        binding.pay.setOnClickListener {
            val intent = Intent (getActivity(), RazorpayActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        binding.circularProgressBar.apply {
            // Set Progress
            progress = 20f
            // or with animation
//            setProgressWithAnimation(65f, 1000) // =1s

            // Set Progress Max
            progressMax = 200f

            // Set ProgressBar Color
            progressBarColor = Color.RED
            // or with gradient
//            progressBarColorStart = Color.RED
//            progressBarColorEnd = Color.YELLOW
//            progressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

            // Set background ProgressBar Color
            backgroundProgressBarColor = Color.YELLOW
            // or with gradient
//            backgroundProgressBarColorStart = Color.YELLOW
//            backgroundProgressBarColorEnd = Color.YELLOW
//            backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

            // Set Width
            progressBarWidth = 13f // in DP
            backgroundProgressBarWidth = 13f // in DP
            // Other
          //  roundBorder = true
            startAngle = 360f
            progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
        }
        binding.bck.setOnClickListener {
            findNavController().navigate(R.id.action_decencyScoreFragment_to_enterRangeFragment)
        }
        binding.decline.setOnClickListener {
            Toast.makeText(requireActivity(),"Payment Declined", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_decencyScoreFragment_to_lenderFragment)
        }
        return binding.root
    }

}