package com.example.mvvmtest.data

class FakeDatabase private constructor(){


    companion object{
        @Volatile private var instance:FakeDatabase? = null

        var quoteDao = FakeDAO()
            private set

        fun getInstance()=
            instance ?: synchronized(this){
                instance ?:FakeDatabase().also { instance = it }
            }
    }
}