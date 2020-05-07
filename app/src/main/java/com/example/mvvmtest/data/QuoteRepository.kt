package com.example.mvvmtest.data

class QuoteRepository private constructor(private val quoteDao:FakeDAO){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }
    fun getQuote() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance:QuoteRepository? = null

        fun getInstance(quoteDao: FakeDAO)=
            instance ?: synchronized(this){
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}