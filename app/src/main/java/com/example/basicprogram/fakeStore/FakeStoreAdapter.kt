package com.example.basicprogram.fakeStore

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import com.iarcuschin.simpleratingbar.SimpleRatingBar
import com.squareup.picasso.Picasso


@Suppress("DEPRECATION")
class FakeStoreAdapter(
    private var fakeStoreList: ArrayList<FakeStoreItem>,
    private var mListener: ItemClickListener,
) :
    RecyclerView.Adapter<FakeStoreAdapter.FakeStoreViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeStoreViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fake_store, parent, false)
        return FakeStoreViewHolder(itemView, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FakeStoreViewHolder, position: Int) {

        holder.price.text = "$" + fakeStoreList[position].price
        holder.title.text = fakeStoreList[position].title
        holder.category.text = fakeStoreList[position].category
        holder.description.text = fakeStoreList[position].description
        holder.ratingRate.rating = fakeStoreList[position].rating.rate.toFloat()
        holder.ratingCount.text = fakeStoreList[position].rating.count.toString()
        Picasso.get().load(fakeStoreList[position].image).into(holder.image)
    }

    interface ItemClickListener {
        fun onItemClickListener(position: Int)

    }


    override fun getItemCount(): Int {
        return fakeStoreList.size
    }

    class FakeStoreViewHolder(itemView: View, listener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.txt_title)
        val category: TextView = itemView.findViewById(R.id.txt_category)
        val price: TextView = itemView.findViewById(R.id.txt_price)
        val description: TextView = itemView.findViewById(R.id.txt_desc)
        val ratingRate: SimpleRatingBar = itemView.findViewById(R.id.txt_rating_rate)
        val ratingCount: TextView = itemView.findViewById(R.id.txt_rating_count)
        val image: ImageView = itemView.findViewById(R.id.storeImg)

        init {
            itemView.setOnClickListener {
                listener.onItemClickListener(adapterPosition)
            }
        }
    }
}
