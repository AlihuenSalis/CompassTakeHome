package com.example.compasstakehome.domain.usesCase

import com.example.compasstakehome.data.repository.Repository
import com.example.compasstakehome.domain.model.EventApiData
import retrofit2.awaitResponse
import javax.inject.Inject

class GetDataUC @Inject constructor(
    private val repository: Repository){

    suspend operator fun invoke(): EventApiData {
        val response = repository.getDataFromDatabase()
        return if (response != null) {
            println("DATABASE RESPONSE")
            response
        } else {
            val apiResponse = repository.getDataFromApi()
            if (apiResponse.data != null) {
                repository.insertData(apiResponse) }
            apiResponse
        }
    }

    //    suspend operator fun invoke(): EventApiData {
//        val response = repository.getDataFromDatabase()
//        return if (response != null) {
//            println("DATABASE RESPONSE")
//            response
//        } else {
//            return repository.getDataFromApi()
//        }
//    }
}