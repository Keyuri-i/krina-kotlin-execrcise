package com.example.basicprogram.fakeStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FakeStoreActivity : AppCompatActivity(), FakeStoreAdapter.ItemClickListener,
    CategoryAdapter.ItemClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var catRecyclerView: RecyclerView
    lateinit var fakeAdapter: FakeStoreAdapter
    lateinit var fakeStoreArray: ArrayList<FakeStoreItem>
    lateinit var categoryItem: CategoryItem
    lateinit var catAdapter: CategoryAdapter
    private lateinit var spinner: Spinner
    lateinit var progressBar: ProgressBar
    private lateinit var dialog: BottomSheetDialog
    lateinit var title: TextView
    lateinit var close: ImageView

    @SuppressLint("MissingInflatedId", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fake_store)

        //ArrayList of Sorting Item
        val orders = resources.getStringArray(R.array.order)

        title = findViewById(R.id.category_title)


        //Add New Product Button Click
        val addItem: ImageView = findViewById(R.id.imgAdd)
        addItem.setOnClickListener {
            val intent = Intent(this@FakeStoreActivity, AddProductActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recycler_view)

        fakeStoreArray = ArrayList()
        progressBar = findViewById(R.id.progressbar)

        //All Products Recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        //Bottom Sheet Dialog
        dialog = BottomSheetDialog(this@FakeStoreActivity)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        close = view.findViewById(R.id.close_img)
        catRecyclerView = view.findViewById(R.id.catRecycler)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(view)


        //Category Recyclerview
        catRecyclerView.layoutManager = LinearLayoutManager(this)
        catRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        //Set Spinner Data
        spinner = findViewById(R.id.spinner)
        spinner.setPadding(10, 10, 10, 10)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, orders)
        spinner.adapter = adapter


        //Spinner Item Click to get Data
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long,
            ) {
                when (position) {
                    0 -> {
                        getStoreItem()
                    }
                    1 -> {
                        getSortingData()
                    }
                    2 -> {
                        getBottomSheet()
                        close.setOnClickListener { dialog.dismiss() }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@FakeStoreActivity, "Please Select", Toast.LENGTH_SHORT).show()
            }
        }
    }


    //Call Category Api
    private fun getBottomSheet() {
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<CategoryItem> = fakeStoreApi.getCategory()

        call.enqueue(object : Callback<CategoryItem> {
            override fun onResponse(
                call: Call<CategoryItem>,
                response: Response<CategoryItem>,
            ) {
                if (response.isSuccessful) {
                    progressBar.isGone = true
                    dialog.show()
                    categoryItem = response.body()!!
                    catAdapter = CategoryAdapter(categoryItem, this@FakeStoreActivity)
                    catRecyclerView.adapter = catAdapter
                }
            }

            override fun onFailure(call: Call<CategoryItem>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Category not shown..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call Sorting Data Api
    private fun getSortingData() {
        title.isGone = true
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getSortingProducts("desc")
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {
                if (response.isSuccessful) {
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                    return
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Data not sorted..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call All Products Api
    private fun getStoreItem() {
        title.isGone = true
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getProducts()
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {
                if (response.isSuccessful) {
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call Jewelery Item Api
    private fun getJeweleryItem() {
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getJewelery()
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {

                if (response.isSuccessful) {
                    title.isGone = false
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call Electronics Item Api
    private fun getElectronicItem() {
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getElectronics()
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {
                if (response.isSuccessful) {
                    title.isGone = false
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call Mens Clothing Api
    private fun getMensItem() {
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getMenClothing()
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {
                if (response.isSuccessful) {
                    title.isGone = false
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //Call Women Clothing Api
    private fun getWomenItem() {
        progressBar.isGone = false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<ArrayList<FakeStoreItem>> = fakeStoreApi.getWomenClothing()
        call.enqueue(object : Callback<ArrayList<FakeStoreItem>> {
            override fun onResponse(
                call: Call<ArrayList<FakeStoreItem>>,
                response: Response<ArrayList<FakeStoreItem>>,
            ) {
                if (response.isSuccessful) {
                    title.isGone = false
                    progressBar.isGone = true
                    fakeStoreArray = response.body()!!
                    fakeAdapter = FakeStoreAdapter(fakeStoreArray, this@FakeStoreActivity)
                    recyclerView.adapter = fakeAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<FakeStoreItem>>, t: Throwable) {
                Toast.makeText(this@FakeStoreActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    //All Product Item Click
    override fun onItemClickListener(position: Int) {

        val intent = Intent(this@FakeStoreActivity, DetailActivity::class.java)
        intent.putExtra("json", fakeStoreArray[position])
        startActivity(intent)
    }


    //Category Item Click
    override fun onCatItemClickListener(position: Int) {
        when (position) {
            0 -> getElectronicItem()
            1 -> getJeweleryItem()
            2 -> getMensItem()
            3 -> getWomenItem()
        }
        title.text = categoryItem[position]
        dialog.dismiss()
    }
}