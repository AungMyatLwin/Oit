package com.rig.oit.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    fun insertItem(items: Items)

    @Query("Select * from items")
    fun getAllItems(): List<Items>
}
