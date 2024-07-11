package com.example.compasstakehome.data.network.service


import com.example.compasstakehome.data.network.ApiClient
import com.example.compasstakehome.domain.model.EventApiData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject

class ApiService @Inject constructor(private val api: ApiClient) {

    suspend fun getDataForEvery10ThCharacter(): Call<String> {
        return withContext(Dispatchers.IO) {
            api.getDataForEvery10ThCharacter()
        }
    }

    suspend fun getDataForSplit(): Call<String> {
        return withContext(Dispatchers.IO) {
            api.getDataForSplit()
        }
    }
}