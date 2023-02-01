package com.example.basicprogram.movieApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieObject {
    fun getMovieInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/demos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}