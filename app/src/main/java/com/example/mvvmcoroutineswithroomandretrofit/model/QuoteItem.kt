package com.example.mvvmcoroutineswithroomandretrofit.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuoteItem(

    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val author: String,
    val text: String
)