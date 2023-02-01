package com.example.basicprogram.movieApi


import retrofit2.Call
import retrofit2.http.GET

interface MovieInterface {
    @GET("marvel")
     fun getMovie() : Call<ArrayList<MoviesItem>>
}