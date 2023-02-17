@file:Suppress("DEPRECATION")

package com.example.basicprogram.fakeStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.basicprogram.R
import com.iarcuschin.simpleratingbar.SimpleRatingBar
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var titleText: TextView
    private lateinit var descText: TextView
    private lateinit var priceText: TextView
    private lateinit var countText: TextView
    private lateinit var categoryText: TextView
    private lateinit var itemImage: ImageView
    private lateinit var ratingBar: SimpleRatingBar
    private lateinit var backArrow: ImageView


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleText = findViewById(R.id.title_txt)
        descText = findViewById(R.id.desc_txt)
        priceText = findViewById(R.id.price_txt)
        countText = findViewById(R.id.rating_count)
        categoryText = findViewById(R.id.detail_txt)
        itemImage = findViewById(R.id.detail_img)
        ratingBar = findViewById(R.id.rating_rate)

        backArrow = findViewById(R.id.imgBack)
        backArrow.setOnClickListener {
            val intent = Intent(this, FakeStoreActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }


        //   val item: FakeStoreItem? = intent.extras!!.getParcelable("json")


        //Get All Product Data using Serializable
        val item = intent.getSerializableExtra("json") as FakeStoreItem?

        titleText.text = item!!.title
        descText.text = item.description
        priceText.text = "$ ${item.price}"
        countText.text = item.rating.count.toString()
        ratingBar.rating = item.rating.rate.toFloat()
        categoryText.text = item.category
        Picasso.get().load(item.image).into(itemImage)

      //  val id = intent.getStringExtra("ID")

    }
}