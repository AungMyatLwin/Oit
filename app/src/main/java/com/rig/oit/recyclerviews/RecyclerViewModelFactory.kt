package com.rig.oit.recyclerviews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rig.oit.room.ItemRepository
import com.rig.oit.viewmodel.MyViewModel


class MyViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}