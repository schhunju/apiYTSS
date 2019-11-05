package com.example.secondapiretro

import com.google.gson.annotations.SerializedName

class Meta (
@SerializedName("server_time") val server_time : Int,
@SerializedName("server_timezone") val server_timezone : String,
@SerializedName("api_version") val api_version : Int,
@SerializedName("execution_time") val execution_time : String
)

class Data (
    @SerializedName("movie_count") val movie_count : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("page_number") val page_number : Int,
    @SerializedName("movies") val movies : ArrayList<Movies>,
    @SerializedName("movie") val movie: Movies
)

class RootObject (

    @SerializedName("status") val status : String,
    @SerializedName("status_message") val status_message : String,
    @SerializedName("data") val data : Data,
    @SerializedName("@meta") val meta : Meta
)

class Movies (
    @SerializedName("id") val id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("imdb_code") val imdb_code : String,
    @SerializedName("title") val title : String,
    @SerializedName("title_english") val title_english : String,
    @SerializedName("title_long") val title_long : String,
    @SerializedName("slug") val slug : String,
    @SerializedName("year") val year : Int,
    @SerializedName("rating") val rating : Double,
    @SerializedName("runtime") val runtime : Int,
    @SerializedName("genres") val genres : List<String>,
    @SerializedName("summary") val summary : String,
    @SerializedName("description_full") val description_full : String,
    @SerializedName("synopsis") val synopsis : String,
    @SerializedName("yt_trailer_code") val yt_trailer_code : String,
    @SerializedName("language") val language : String,
    @SerializedName("mpa_rating") val mpa_rating : String,
    @SerializedName("background_image") val background_image : String,
    @SerializedName("background_image_original") val background_image_original : String,
    @SerializedName("small_cover_image") val small_cover_image : String,
    @SerializedName("medium_cover_image") val medium_cover_image : String,
    @SerializedName("large_cover_image") val large_cover_image : String,
    @SerializedName("state") val state : String,
    @SerializedName("torrents") val torrents : List<Torrents>,
    @SerializedName("date_uploaded") val date_uploaded : String,
    @SerializedName("date_uploaded_unix") val date_uploaded_unix : Int
)

class Torrents (
    @SerializedName("url") val url : String,
    @SerializedName("hash") val hash : String,
    @SerializedName("quality") val quality : String,
    @SerializedName("type") val type : String,
    @SerializedName("seeds") val seeds : Int,
    @SerializedName("peers") val peers : Int,
    @SerializedName("size") val size : String,
    @SerializedName("size_bytes") val size_bytes : Long,
    @SerializedName("date_uploaded") val date_uploaded : String,
    @SerializedName("date_uploaded_unix") val date_uploaded_unix : Long
)