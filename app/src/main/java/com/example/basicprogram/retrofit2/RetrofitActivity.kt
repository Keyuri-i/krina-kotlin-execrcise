package com.example.basicprogram.retrofit2

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    lateinit var quotesApis:ArrayList<QuoteList>
    lateinit var recycler:RecyclerView
    lateinit var retroAdapter: RetroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        recycler=findViewById(R.id.list_view)
        quotesApis= ArrayList()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        getData()

    }

    private fun getData() {
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi ::class.java)

        val call: Call<ArrayList<QuoteList>> = quotesApi.getQuotes()

        call.enqueue(object : Callback<ArrayList<QuoteList>>{
            override fun onResponse(
                call: Call<ArrayList<QuoteList>>,
                response: Response<ArrayList<QuoteList>>
            ) {

              //  val que =quotesApi.getQuotes()
                if (response.isSuccessful){
                    Log.d("Retro" ,call.toString())
                    quotesApis = response.body()!!
                }

              //  retroAdapter = RetroAdapter(call)
                recycler.adapter=retroAdapter
            }

            override fun onFailure(call: Call<ArrayList<QuoteList>>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}