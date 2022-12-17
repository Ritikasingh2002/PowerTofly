package com.hackygirls.kavachh.`interface`

import com.hackygirls.kavachh.dataClass.*
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private var  base_url = "https://kavach-amex.herokuapp.com/KavachAuth/"
interface SignupInterface {

    @POST("/Register/Lender/")
    fun signup(@Body response : Signup): Call<Signup>
    @POST("/Register/Lender/")
    fun crProfile(@Body respone : Signup2) : Call<Signup2>
    @POST("/Register/Borrower/")
    fun regbbrwr(@Body response : BorrowerRegstr) : Call<signres>
    @POST("/Register/Borrower/")
    fun brProfile(@Body response : BorrowerRegstr2) : Call<signres>
    @POST("/Login/Lender/")
    fun login(@Body response : Login) : Call<signres>

}
object SignupService{
    val signupInstance : SignupInterface
    init {
         val retrofit = Retrofit.Builder()
            .baseUrl("https://kavach-amex.herokuapp.com/KavachAuth/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        signupInstance = retrofit.create(SignupInterface::class.java)
    }
}