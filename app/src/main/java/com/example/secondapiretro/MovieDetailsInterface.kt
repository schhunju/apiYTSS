package com.example.secondapiretro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieDetailsInterface {
    @GET("list_movies.json")
    fun getMovieDetails(
        @Query("id") id: Int
    ):Call<RootObject>

}