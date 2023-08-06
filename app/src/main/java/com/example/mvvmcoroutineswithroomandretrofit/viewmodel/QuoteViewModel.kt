package com.example.mvvmcoroutineswithroomandretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcoroutineswithroomandretrofit.model.QuoteItem
import com.example.mvvmcoroutineswithroomandretrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes()
        }
    }

      fun getAllQuotes(): List<QuoteItem> {
        val quotesList = quoteRepository.getAllQuotes()
        return quotesList
    }

    val quotes :LiveData<List<QuoteItem>>
        get() = quoteRepository.quotes
}