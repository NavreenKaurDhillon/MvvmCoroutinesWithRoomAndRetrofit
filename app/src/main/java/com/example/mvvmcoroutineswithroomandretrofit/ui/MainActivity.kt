package com.example.mvvmcoroutineswithroomandretrofit.ui

import android.content.ContentValues.TAG
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcoroutineswithroomandretrofit.R
import com.example.mvvmcoroutineswithroomandretrofit.api.ApiInterface
import com.example.mvvmcoroutineswithroomandretrofit.api.RetrofitHelper
import com.example.mvvmcoroutineswithroomandretrofit.db.QuoteDatabase
import com.example.mvvmcoroutineswithroomandretrofit.repository.QuoteRepository
import com.example.mvvmcoroutineswithroomandretrofit.viewmodel.MainViewModelFactory
import com.example.mvvmcoroutineswithroomandretrofit.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val dao = QuoteDatabase.getDbInstance(this).getQuoteDao()
        val quoteRepository = QuoteRepository(apiInterface, dao, applicationContext)
        val mainViewModelFactory = MainViewModelFactory(quoteRepository)
         quoteViewModel = ViewModelProvider(this, mainViewModelFactory).get(QuoteViewModel::class.java)

        quoteViewModel.quotes.observe(this, Observer {
            Log.d(TAG, "onCreate: //"+it)
//            Log.d(TAG, "onCreate: db //"+quoteViewModel.getAllQuotes())
        })


    }

}