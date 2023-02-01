package com.example.basicprogram.movieApi

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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var movieAdapter: MovieAdapter
    lateinit var movieInterface: ArrayList<MoviesItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        recyclerView=findViewById(R.id.listView)
        movieInterface= ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        getAllCourses()
    }

    private fun getAllCourses() {

        val retrofitApi = MovieObject.getMovieInstance().create(MovieInterface::class.java)

        val call: Call<ArrayList<MoviesItem>> = retrofitApi.getMovie()

        call.enqueue(object : Callback<ArrayList<MoviesItem>>{
            override fun onResponse(
                call: Call<ArrayList<MoviesItem>>,
                response: Response<ArrayList<MoviesItem>>
            ) {
              //  movieInterface = response.body()!!
                if (response.isSuccessful) {
                   Log.d("Data",response.body().toString())
                    movieInterface = response.body()!!
                }
                movieAdapter = MovieAdapter(movieInterface)
                recyclerView.adapter=movieAdapter
            }

            override fun onFailure(call: Call<ArrayList<MoviesItem>>, t: Throwable) {
                Toast.makeText(this@MoviesActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}


