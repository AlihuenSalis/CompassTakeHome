package com.example.compasstakehome.domain.usesCase

import com.example.compasstakehome.data.network.service.ApiService
import com.example.compasstakehome.data.repository.Repository
import com.example.compasstakehome.domain.model.EventApiData
import retrofit2.Call
import javax.inject.Inject

class InsertDataUC @Inject constructor(private val repository: Repository) {

    suspend fun insertDataInDatabase(data: EventApiData): Boolean {
        return repository.insertData(data)
    }
}