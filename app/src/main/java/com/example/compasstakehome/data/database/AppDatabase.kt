package com.example.compasstakehome.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compasstakehome.data.database.dao.DataDao
import com.example.compasstakehome.domain.model.EventApiData

@Database(entities = [EventApiData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDataDao(): DataDao

}