package com.example.compasstakehome.di

import android.content.Context
import androidx.room.Room
import com.example.compasstakehome.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    companion object {
        private const val DATABASE_NAME = "compassTakeHome"
    }

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideDataDao(db: AppDatabase) = db.getDataDao()
}