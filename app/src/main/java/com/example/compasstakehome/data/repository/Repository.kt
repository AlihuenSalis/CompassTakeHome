package com.example.compasstakehome.data.repository

import com.example.compasstakehome.data.database.dao.DataDao
import com.example.compasstakehome.data.network.service.ApiService
import com.example.compasstakehome.domain.model.EventApiData
import retrofit2.awaitResponse
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataDao: DataDao,
    private val service: ApiService
) {

    suspend fun insertData(data: EventApiData): Boolean {
        val response = dataDao.insertData(data)
        return response != 0L
    }

    suspend fun getDataFromDatabase(): EventApiData? {
        return dataDao.getData()
    }

    suspend fun getDataFromApi(): EventApiData {
        val apiResponse = service.getDataForEvery10ThCharacter()
        val data = apiResponse.awaitResponse().body().toString()
        val eventApi = EventApiData(id = null, data = data)
        println("API RESPONSE")
        return eventApi
    }

//    val apiResponse = service.getDataForEvery10ThCharacter()
//    val apiData = apiResponse.awaitResponse().body().toString()
//    val eventApi = EventApiData(id = null, data = apiData)
//    if (!eventApi.data.isNullOrEmpty()) {
//        insertData(eventApi) }
//    println("API RESPONSE")
//    return eventApi
}