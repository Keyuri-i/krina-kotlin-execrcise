package com.example.basicprogram.fakeStore

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FakeStoreObject {

    fun getFakeStoryObject() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}