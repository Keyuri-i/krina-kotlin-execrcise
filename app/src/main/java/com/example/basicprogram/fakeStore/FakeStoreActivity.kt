package com.example.basicprogram.fakeStore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class FakeStoreActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fakeAdapter : FakeStoreAdapter
    lateinit var fakeStoreArray: ArrayList<FakeStoreItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fake_store)

        recyclerView = findViewById(R.id.recycler_view)
        fakeStoreArray=ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)


        getStoreItem()
    }

    private fun getStoreItem() {
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getProducts()
        call.enqueue(object :Callback<ArrayList<FakeStoreItem>>{
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>
            ) {
                if (response.isSuccessful){
                    fakeStoreArray = response.body()!!
                }

                fakeAdapter = FakeStoreAdapter(fakeStoreArray)
                recyclerView.adapter=fakeAdapter
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }
}