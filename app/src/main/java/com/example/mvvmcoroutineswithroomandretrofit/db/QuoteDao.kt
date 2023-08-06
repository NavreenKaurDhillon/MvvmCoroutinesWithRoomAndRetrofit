package com.example.mvvmcoroutineswithroomandretrofit.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmcoroutineswithroomandretrofit.model.QuoteItem

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
      fun getQuotesFromDb() : List<QuoteItem>

    @Insert
    suspend fun insertQuoteIntoDb(quoteItem: List<QuoteItem>)
}