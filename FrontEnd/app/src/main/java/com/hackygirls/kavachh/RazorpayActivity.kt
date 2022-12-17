package com.hackygirls.kavachh

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class RazorpayActivity : AppCompatActivity(), PaymentResultListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_razorpay)
        val amountEditText = findViewById<TextInputEditText>(R.id.amount)
        val process = findViewById<MaterialButton>(R.id.process_payment)



        process.setOnClickListener {

            val amount = amountEditText.text.toString().trim()

            if (amount.isEmpty()) return@setOnClickListener



            startPayment(amount.toInt())

        }
    }
    private fun startPayment(amount: Int) {
        val checkout=Checkout()
        checkout.setKeyID("rzp_test_3AuRUq8vpYjZEG")
        try {
            val options=JSONObject()
            options.put("name","Send Money")
            options.put("description","Enter the details of your borrower's account")
            options.put("image","https://cdn.razorpay.com/logos/J4aMpjoJsqnhRg_medium.png")

            options.put("theme.color","#eebaec")
            options.put("currency","INR")

            options.put("amount","${(amount.toInt()*100)}")

            options.put("prefill.email","ananyapunia12@gmail.com")
            options.put("prefill.contact","+917906595546")
            checkout.open(this,options)


        }
        catch (e:Exception){
            Toast.makeText(this,"Error in Payment"+e.message,Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }


    }


    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment Success$p0", Toast.LENGTH_SHORT).show()
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Log.d(TAG,"onPaymentError: $p0")
        Log.d(TAG,"onPaymentError: $p1")

        Toast.makeText(this, "Payment not successful$p0 $p1", Toast.LENGTH_SHORT).show()
        finish()
    }
}