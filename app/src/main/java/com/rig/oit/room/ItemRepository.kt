package com.rig.oit.room

class ItemRepository(private val dao: ItemDao) {
    fun getItems(): List<Items> {
        return dao.getAllItems()
    }

    fun insertItem(item:Items){
        dao.insertItem(item)
    }
}