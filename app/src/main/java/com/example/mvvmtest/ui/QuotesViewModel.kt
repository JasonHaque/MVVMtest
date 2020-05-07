package com.example.mvvmtest.ui

import androidx.lifecycle.ViewModel
import com.example.mvvmtest.data.Quote
import com.example.mvvmtest.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {


    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() =  quoteRepository.getQuote()


}