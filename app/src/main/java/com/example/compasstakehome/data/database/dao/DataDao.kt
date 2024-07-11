package com.example.compasstakehome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.compasstakehome.domain.model.EventApiData

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: EventApiData): Long

    @Query("SELECT * FROM event_api_data_table")
    suspend fun getData(): EventApiData?
}