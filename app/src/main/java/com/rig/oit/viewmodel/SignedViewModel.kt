package com.rig.oit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rig.oit.room.ItemRepository
import com.rig.oit.room.Items


class SignedViewModel(val repository: ItemRepository): ViewModel() {
    private val _getItems = MutableLiveData<List<Items>>()
    val getItems: LiveData<List<Items>> = _getItems
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