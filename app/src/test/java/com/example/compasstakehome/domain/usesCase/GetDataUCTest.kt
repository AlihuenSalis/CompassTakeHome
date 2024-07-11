package com.example.compasstakehome.domain.usesCase

import com.example.compasstakehome.data.repository.Repository
import com.example.compasstakehome.domain.model.EventApiData
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetDataUCTest {

    @RelaxedMockK
    private lateinit var repository: Repository

    lateinit var getDataUC: GetDataUC
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getDataUC = GetDataUC(repository)
    }

    @Test
    fun whenTheDatabaseDoesNotReturnAnythingThenGetValueFromApi() = runBlocking{

        //Given
        coEvery { repository.getDataFromDatabase() } returns null

        //When
         val response = getDataUC()

        //Then
        coVerify(exactly = 1) { repository.getDataFromApi() }
        assert(response.data != null)
        coVerify { repository.insertData(any()) }

    }

    @Test
    fun whenTheDatabaseReturnSomethingThenReturnNewValue() = runBlocking{

        //Given
        val myData = EventApiData(1, "My string test")
        coEvery { repository.getDataFromDatabase() } returns myData

        //When
        val response = getDataUC()

        //Then
        assert(response.data != null)
        assert(myData == response)
    }

//    @Test
//    fun whenTheDatabaseReturnSomethingThenReturnValue() = runBlocking{
//
//        //Given
//        val data = EventApiData(1, "My test string")
//        coEvery { repository.getDataFromDatabase() } returns data
//
//        //When
//        val response = getDataUC()
//
//        //Then
//        coVerify(exactly = 1) { repository.getDataFromApi() }
//
//    }

}