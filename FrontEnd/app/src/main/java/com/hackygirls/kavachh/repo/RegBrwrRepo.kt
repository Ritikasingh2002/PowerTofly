package com.hackygirls.kavachh.repo

import com.hackygirls.kavachh.`interface`.SignupService
import com.hackygirls.kavachh.dataClass.BorrowerRegstr
import com.hackygirls.kavachh.dataClass.BorrowerRegstr2
import com.hackygirls.kavachh.dataClass.signres
import retrofit2.Call

class RegBrwrRepo {
    fun regbrwr(email: String,
                 password: String,
                 username: String) : Call<signres>{
        return SignupService.signupInstance.regbbrwr(BorrowerRegstr(email,password, username))
    }
    fun brProfile( account_number: String,
                   contact_no: String,
                   first_name: String,
                   last_name: String) : Call<signres>{
        return SignupService.signupInstance.brProfile(BorrowerRegstr2(account_number, contact_no, first_name, last_name))
    }
}