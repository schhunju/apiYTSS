package com.example.secondapiretro


import retrofit2.Call
import retrofit2.http.GET
import com.google.gson.JsonObject



interface DataInterface {

    @GET("list_movies.json")
    fun getMovies():Call<RootObject>

    //fun getLimit(
     //   @Query("address") zipCode: String,
     //   @Query("sensor") sensor: Boolean,
     //   @Query("client") client: String,
     //   @Query("signature") signature: String
    //): Call<Movies>
}