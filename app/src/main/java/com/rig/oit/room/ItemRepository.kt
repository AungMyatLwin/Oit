package com.rig.oit.room

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.rig.oit.Users.User

class ItemRepository(private val dao: ItemDao) {

    val url ="https://dummyproject-607fd-default-rtdb.asia-southeast1.firebasedatabase.app"
    val dbs =  FirebaseDatabase.getInstance(url)
    val ref = dbs.getReference()

    val refConnection = ref.ref
//.ref(".info/connected"); cant use


    fun getItems(email:String): List<Items> {
        return dao.getAllItems(email)
    }

    fun insertItem(item:Items){
        dao.insertItem(item)
    }

    fun deleteRow(email: String){
        return dao.deleteRows(email)
    }


    fun signIn(emailInput:String, password:String, callback: (Boolean) -> Unit):Boolean{
        var flag:Boolean = false
        var email:String?=null
        var pwd:String?=null
        ref.child("signup").child(emailInput).get().addOnSuccessListener {
            email=it.child("email").value as String?
            pwd=it.child("password").value as String?
            flag = email == emailInput && pwd == password
            callback(flag)
            Log.i("firebase", "Got value email ${it.value} $email $pwd, $emailInput $password $flag $refConnection")

        }.addOnFailureListener{
            callback(false)
            Log.e("firebase", "Error getting data $flag", it)
        }
        return flag
    }


    fun signup(xEmail:String, xPassword:String){
            ref.child("signup").child(xEmail).setValue(User(xEmail,xPassword))
    }

}