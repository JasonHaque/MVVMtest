package com.example.mvvmtest.utilities

import com.example.mvvmtest.data.FakeDatabase
import com.example.mvvmtest.data.QuoteRepository
import com.example.mvvmtest.ui.QuotesViewModelFactory

object Injectorutils {

    fun provideQuoteViewModelFactory():QuotesViewModelFactory{
        val  quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return  QuotesViewModelFactory(quoteRepository)
    }
}