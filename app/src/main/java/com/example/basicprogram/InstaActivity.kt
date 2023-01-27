package com.example.basicprogram

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.adapter.InstaAdapter

class InstaActivity : AppCompatActivity() {

    private lateinit var instaAdapter:InstaAdapter
    private val itemList:ArrayList<ItemViewModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta)

        instaAdapter= InstaAdapter(itemList)

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)

        var item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
        item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
        item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
        item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
        item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
        item=ItemViewModel(R.drawable.profile_pic,"Maria")
        itemList.add(item)
      // instaAdapter.notifyDataSetChanged()
        recyclerView.adapter=instaAdapter
       // recyclerView.setHasFixedSize(true)
    }
}