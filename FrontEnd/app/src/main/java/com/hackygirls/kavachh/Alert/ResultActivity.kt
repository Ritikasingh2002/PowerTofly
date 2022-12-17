package com.hackygirls.kavachh.Alert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackygirls.kavachh.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        if (intent.getBooleanExtra("notification", false)) { //Just for confirmation
//            txtTitleView.text = intent.getStringExtra("title")
//            txtMsgView.text = intent.getStringExtra("message")

        }
    }
}