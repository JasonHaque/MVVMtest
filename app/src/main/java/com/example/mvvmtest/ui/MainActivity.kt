package com.example.mvvmtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmtest.R
import com.example.mvvmtest.data.Quote
import com.example.mvvmtest.utilities.Injectorutils
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Initializeui()
    }

    private fun Initializeui(){
        val factory = Injectorutils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()

        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }


    }
}
