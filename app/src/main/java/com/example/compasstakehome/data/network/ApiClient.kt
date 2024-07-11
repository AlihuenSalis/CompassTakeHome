package com.example.compasstakehome.data.network


import com.example.compasstakehome.domain.model.EventApiData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiClient {


    @Headers("Content-Type: text/html")
    @GET("/about")
    fun getDataForEvery10ThCharacter(): Call<String>

    @Headers("Content-Type: text/html")
    @GET("/about")
    suspend fun getDataForSplit(): Call<String>
}