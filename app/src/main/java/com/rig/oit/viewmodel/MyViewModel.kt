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
        msg.value = ""
    }

    fun setEmail(x:String){
        email.value =  x
    }

    fun setName(x:String){
        password.value = x
    }

    fun signUp(){
        msg.value =  "${livedataEmail.value} and ${livedataPassword.value}"
        Log.d("Sgs", "signUp:${msg.value} ")
    }
    fun signIn(){

    }
}