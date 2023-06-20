package com.rig.oit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.rig.oit.Users.User
import com.rig.oit.room.ItemRepository
import com.rig.oit.room.Items


class SignedViewModel(private val repository: ItemRepository): ViewModel() {


    private val _getItems = MutableLiveData<List<Items>>()

    val url ="https://dummyproject-607fd-default-rtdb.asia-southeast1.firebasedatabase.app"
    val dbs =  FirebaseDatabase.getInstance(url)
    val ref = dbs.getReference()

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
        var flag:Boolean = false
        ref.child("signup").child(emailInput).get().addOnSuccessListener {
            val email=it.child(emailInput).value as String?
            val pwd=it.child(password).value as String?
//            I/firebase: Got value {password=12, email=qr} false null null
            if(emailInput==email && password==pwd)
                flag=true
            Log.i("firebase", "Got value ${it.value} $flag $email $pwd")

        }.addOnFailureListener{
            Log.e("firebase", "Error getting data $flag", it)
        }

    }

    fun signupSave(xName:String, xEmail: String, xPassword:String, xRePassword:String){
        if(checkPassword(xPassword, xRePassword)){
            ref.child("signup").child(xEmail).setValue(User(xEmail,xPassword))
        }
        msg.value =  "${email.value} and ${password.value} ${passwordReSignup.value}  ${signUpName.value}"
    }

    fun checkPassword(p1:String, p2:String):Boolean{
        return p1 == p2
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