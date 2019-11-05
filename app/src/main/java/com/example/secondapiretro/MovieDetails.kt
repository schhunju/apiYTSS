package com.example.secondapiretro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetails(_id:Int) : AppCompatActivity() {

    val id:Int
    init {
        this.id=_id
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val context = this

        val retrofit=Retrofit.Builder()
            .baseUrl("https://yts.lt/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieInterface: MovieDetailsInterface=retrofit.create(MovieDetailsInterface::class.java)
        val call: Call<RootObject> = movieInterface.getMovieDetails(id)

        call.enqueue(object : Callback<RootObject> {
            override fun onFailure(call: Call<RootObject>, t: Throwable) {
                Toast.makeText(this@MovieDetails,"FAILED",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<RootObject>, response: Response<RootObject>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@MovieDetails, "failll", Toast.LENGTH_SHORT).show()
                }
                else{
                    val post : RootObject=response.body()!!
                    val mvd=post.data.movie

                    tv_title.text=mvd.title
                    tv_year.text= mvd.year.toString()
                    tv_genre.text=mvd.genres.toString()
                    tv_description.text=mvd.description_full.toString()

                }
            }

        })


    }
}
