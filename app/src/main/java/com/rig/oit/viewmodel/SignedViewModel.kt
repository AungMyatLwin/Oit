package com.rig.oit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rig.oit.room.ItemRepository
import com.rig.oit.room.Items


class SignedViewModel(private val repository: ItemRepository): ViewModel() {


    private val _getItems = MutableLiveData<List<Items>>()
    val getItems: LiveData<List<Items>> = _getItems

    private var email=MutableLiveData("String")
    private var password = MutableLiveData("String")
    private var msg = MutableLiveData("String")
    private var signUpName = MutableLiveData("String")
    private var signupRePassword = MutableLiveData("String")




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
        Log.d("tag", "${email.value.toString()}")
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

    fun signIn(emailInput:String, password:String){
        setEmail(emailInput)
        setPassword(password)

        msg.value =  "${this.email.value} and ${this.password.value}"
        Log.d("Sgs", "signIn:${msg.value} ")
    }

    fun signupSave(xName:String, xEmail: String, xPassword:String, xRePassword:String){
        setName(xName)
        setEmail(xEmail)
        setPassword(xPassword)
        setRepassword(xRePassword)
        msg.value =  "${email.value} and ${password.value} ${passwordReSignup.value}  ${signUpName.value}"
    }

    fun getAllItems(){
        _getItems.value = repository.getItems()
    }
    fun insertItems(items: Items){
        repository.insertItem(items)
    }

    fun items():List<Items>{
        return repository.getItems()
    }


}