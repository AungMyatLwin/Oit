package com.rig.oit.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Items(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @ColumnInfo(name = "item_name") val itemName: String?,
    @ColumnInfo(name = "buyFlag") var buyable:Boolean=false,
    @ColumnInfo( name= "email") val email:String?
)