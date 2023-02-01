package com.example.basicprogram.fakeStore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import com.squareup.picasso.Picasso

class FakeStoreAdapter(private var fakeStoreList:ArrayList<FakeStoreItem>) : RecyclerView.Adapter<FakeStoreAdapter.FakeStoreViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeStoreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fake_store,parent,false)
        return FakeStoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FakeStoreViewHolder, position: Int) {
        holder.title.text = fakeStoreList[position].title
        holder.storeId.text = fakeStoreList[position].id.toString()
        holder.category.text = fakeStoreList[position].category
        holder.price.text = fakeStoreList[position].price.toString()
        holder.description.text = fakeStoreList[position].description
        holder.ratingRate.text = fakeStoreList[position].rating.rate.toString()
        holder.ratingCount.text = fakeStoreList[position].rating.count.toString()
        Picasso.get().load(fakeStoreList[position].image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return fakeStoreList.size
    }

    class FakeStoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title:TextView =itemView.findViewById(R.id.txt_title)
            val storeId:TextView =itemView.findViewById(R.id.txt_id)
            val category:TextView =itemView.findViewById(R.id.txt_category)
            val price:TextView =itemView.findViewById(R.id.txt_price)
            val description:TextView =itemView.findViewById(R.id.txt_desc)
            val ratingRate:TextView =itemView.findViewById(R.id.txt_rating_rate)
            val ratingCount:TextView =itemView.findViewById(R.id.txt_rating_count)
            val image:ImageView =itemView.findViewById(R.id.storeImg)


    }
}