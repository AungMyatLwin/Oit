package com.rig.oit.room

class ItemRepository(private val dao: ItemDao) {
    fun getItems(email:String): List<Items> {
        return dao.getAllItems(email)
    }

    fun insertItem(item:Items){
        dao.insertItem(item)
    }


    // add the retrofit here / retrofit or room should be under the repository
}