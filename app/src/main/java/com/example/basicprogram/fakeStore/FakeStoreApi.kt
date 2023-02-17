package com.example.basicprogram.fakeStore

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface FakeStoreApi {

    @GET("products")
    fun getProducts(): Call<ArrayList<FakeStoreItem>>

    @GET("products")
    fun getSortingProducts(@Query("sort") sort: String?): Call<ArrayList<FakeStoreItem>>

/*    @GET("products/id")
    fun getDetails(): Call<ArrayList<FakeStoreItem>>*/

    @GET("products/categories")
    fun getCategory(): Call<CategoryItem>

    @GET("products/category/jewelery")
    fun getJewelery(): Call<ArrayList<FakeStoreItem>>

    @GET("products/category/electronics")
    fun getElectronics(): Call<ArrayList<FakeStoreItem>>

    @GET("products/category/men's%20clothing")
    fun getMenClothing(): Call<ArrayList<FakeStoreItem>>

    @GET("products/category/women's%20clothing")
    fun getWomenClothing(): Call<ArrayList<FakeStoreItem>>


}
