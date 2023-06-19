package com.rig.oit.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Items::class)], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun  itemDao():ItemDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null
        fun getInstance(context: Context): ItemDatabase? {
            synchronized(this){
                var instance = INSTANCE
                if(INSTANCE == null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
                        "items_database"
                    ).allowMainThreadQueries().build()
                }
                return instance
            }
        }
    }
}