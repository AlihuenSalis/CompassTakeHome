package com.example.compasstakehome.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "event_api_data_table")
data class EventApiData (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int?,
    @SerializedName("data") val data: String?
)