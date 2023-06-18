package com.rig.oit.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rig.oit.R

class RecyclerViewAdapter(val testRecyclerView: ArrayList<String>) :RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textview).text = testRecyclerView[position]
    }

    override fun getItemCount(): Int {
        return testRecyclerView.size
    }
}

class MyViewHolder(val v:View):RecyclerView.ViewHolder(v){

}