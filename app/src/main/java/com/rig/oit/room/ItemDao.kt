package com.rig.oit.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {
    @Insert
    fun insertItem(items: Items)

    @Query("Select * from items where email = :email")
    fun getAllItems(email:String): List<Items>

    @Query("Delete from items where email = :email ")
    fun deleteRows(email: String)

}
