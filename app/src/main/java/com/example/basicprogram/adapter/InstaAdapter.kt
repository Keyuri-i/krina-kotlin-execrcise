package com.example.basicprogram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.ItemViewModel
import com.example.basicprogram.R

class InstaAdapter(private var iList: List<ItemViewModel>) :
    RecyclerView.Adapter<InstaAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return iList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return ViewHolder(view.inflate(R.layout.item_insta, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel = iList[position]
        holder.imageView.setImageResource(itemViewModel.image)
        holder.textView.text = itemViewModel.text
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img_shape)
        val textView: TextView = itemView.findViewById(R.id.txt_shape)

    }

}