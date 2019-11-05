package com.example.secondapiretro

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.secondapiretro.Adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context=this


        val retrofit = Retrofit.Builder()
            .baseUrl("https://yts.lt/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val dataInterface: DataInterface = retrofit.create(DataInterface::class.java)

        val call: Call<RootObject> = dataInterface.getMovies()

        call.enqueue(object : Callback<RootObject> {
            override fun onFailure(call: Call<RootObject>, t: Throwable) {
                Toast.makeText(this@MainActivity,"failed",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<RootObject>, response: Response<RootObject>) {
                if (!response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "failll", Toast.LENGTH_SHORT).show()
                }
                else {
                    val post : RootObject =response.body()!!
                    val mv=post.data.movies

                    val layoutManager=GridLayoutManager(context,3)
                    layoutManager.orientation=GridLayoutManager.VERTICAL
                    recycView.layoutManager = layoutManager

                    val adapter=MovieAdapter(context, mv)
                    recycView.adapter=adapter
                }
            }
        })

    }
}

