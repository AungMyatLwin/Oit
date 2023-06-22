package com.rig.oit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rig.oit.room.ItemRepository
import com.rig.oit.room.Items
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities



class SignedViewModel(private val repository: ItemRepository): ViewModel() {

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
    }


    private val _getItems = MutableLiveData<List<Items>>()

    val getItems: LiveData<List<Items>> = _getItems

    private var email=MutableLiveData("String")
    private var password = MutableLiveData("String")
    private var msg = MutableLiveData("String")
    private var signUpName = MutableLiveData("String")
    private var signupRePassword = MutableLiveData("String")

    private val _signInResult = MutableLiveData<Boolean>()
    val signInResult: LiveData<Boolean> = _signInResult

    var livedataEmail :LiveData<String> = email
    var livedataPassword : LiveData<String> = password
    var liveDataMsg :LiveData<String> = msg

    var nameSignup: LiveData<String> = signUpName
    var passwordReSignup:LiveData<String> = signupRePassword

    init {
        signUpName.value = ""
        signupRePassword.value = ""
        email.value = ""
        password.value = ""
    }

    fun setEmail(x:String){
        email.value=x
        Log.d("tag", email.value.toString())
    }
    fun setPassword(x:String){
        password.value = x
    }

    fun setName(x:String){
        signUpName.value = x
    }
    fun setRepassword(x:String){
        signupRePassword.value = x
    }

    fun signIn(emailInput: String, password: String) {
        repository.signIn(emailInput, password) { result ->
            _signInResult.value = result
        }
    }

    fun signupSave(xName:String, xEmail: String, xPassword:String, xRePassword:String){
        if(checkPassword(xPassword, xRePassword)){
            repository.signup(xEmail,xPassword)
        }
        msg.value =  "${email.value} and ${password.value} ${passwordReSignup.value}  ${signUpName.value}"
    }

    private fun checkPassword(p1:String, p2:String):Boolean{
        return p1 == p2
    }

    fun getAllItems(data:String){
        _getItems.value = repository.getItems(data)
    }
    fun insertItems(items: Items){
        repository.insertItem(items)
    }

    fun items(data:String):List<Items>{
        return repository.getItems(data)
    }

    fun deleteRow(data:String){
        return  repository.deleteRow(data)
    }


}