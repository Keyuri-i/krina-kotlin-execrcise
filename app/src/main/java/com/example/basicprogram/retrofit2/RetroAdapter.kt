package com.example.basicprogram.retrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import com.squareup.picasso.Picasso

class RetroAdapter(private var retroList: ArrayList<Result>) :
    RecyclerView.Adapter<RetroAdapter.RetroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetroAdapter.RetroViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_retrofit, parent, false)
        return RetroViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RetroAdapter.RetroViewHolder, position: Int) {
        holder.retroId.text = retroList[position]._id
        holder.retroAuthor.text = retroList[position].author
        holder.retroContent.text = retroList[position].content
        holder.retroDate.text = retroList[position].authorSlug
        //Picasso.get().load(retroList[position].imageurl).into(holder.retroImg)
    }

    override fun getItemCount(): Int {
        return retroList.size
    }

    class RetroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val retroId: TextView = itemView.findViewById(R.id.txtID)
        val retroAuthor: TextView = itemView.findViewById(R.id.txtAuthor)
        val retroContent: TextView = itemView.findViewById(R.id.Content)
        val retroDate: TextView = itemView.findViewById(R.id.Date)

    }
}
