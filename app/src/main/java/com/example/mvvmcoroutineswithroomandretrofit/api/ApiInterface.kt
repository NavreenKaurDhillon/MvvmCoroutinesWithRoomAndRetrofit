package com.example.mvvmcoroutineswithroomandretrofit.api

import com.example.mvvmcoroutineswithroomandretrofit.model.QuoteItem
import retrofit2.http.GET

interface ApiInterface {

    @GET("quotes")
    suspend fun getAllQuotes() : List<QuoteItem>
}