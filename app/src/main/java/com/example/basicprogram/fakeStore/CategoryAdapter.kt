package com.example.basicprogram.fakeStore

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R


@Suppress("DEPRECATION")
class CategoryAdapter(
    private var categoryList: CategoryItem,
    private var mListener: ItemClickListener,
) :
    RecyclerView.Adapter<CategoryAdapter.FakeStoreViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakeStoreViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_sheet, parent, false)
        return FakeStoreViewHolder(itemView, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FakeStoreViewHolder, position: Int) {

        holder.cat.text = categoryList[position]

    }

    interface ItemClickListener {
        fun onCatItemClickListener(position: Int)

    }


    override fun getItemCount(): Int {
        return categoryList.size
    }

    class FakeStoreViewHolder(itemView: View, listener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val cat: TextView = itemView.findViewById(R.id.txtCat)

        init {
            itemView.setOnClickListener {
                listener.onCatItemClickListener(adapterPosition)
            }
        }
    }
}