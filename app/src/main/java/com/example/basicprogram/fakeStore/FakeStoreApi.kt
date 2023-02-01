package com.example.basicprogram.fakeStore

import retrofit2.Call
import retrofit2.http.GET

interface FakeStoreApi {

    @GET("products")
    fun getProducts() : Call<ArrayList<FakeStoreItem>>
}