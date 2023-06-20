package com.rig.oit.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rig.oit.R
import com.rig.oit.room.Items

class RecyclerViewAdapter(val testRecyclerView: List<Items>) :RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textview).text = testRecyclerView[position].itemName.toString()
    }

    override fun getItemCount(): Int {
        return testRecyclerView.size
    }
}

class MyViewHolder(val v:View):RecyclerView.ViewHolder(v){

}