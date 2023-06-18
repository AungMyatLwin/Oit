package com.rig.oit.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var email=MutableLiveData("String")
    private var password = MutableLiveData("String")

    private var msg = MutableLiveData("String")

    var livedataEmail :LiveData<String> = email
    var livedataPassword : LiveData<String> = password
    var liveDataMsg :LiveData<String> = msg

    init {
        email.value = ""
        password.value = ""
    }

    fun setEmail(x:String){
        email.value=x
        Log.d("tag", "${email.value.toString()}")
    }
    fun setPassword(x:String){
        password.value = x
    }
    fun signIn(emailInput:String, password:String){
        setEmail(emailInput)
        setPassword(password)
        msg.value =  "${this.email.value} and ${this.password.value}"
        Log.d("Sgs", "signUp:${msg.value} ")
    }

    fun signUp(){

    }
}