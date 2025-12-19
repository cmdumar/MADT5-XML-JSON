package com.example.madt_5

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var etFilter: EditText
    private lateinit var listView: ListView
    private var allRates = listOf<CurrencyRate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFilter = findViewById(R.id.etFilter)
        listView = findViewById(R.id.listView)

        val loader = DataLoader()
        loader.loadData { rates ->
            runOnUiThread {
                allRates = rates
                displayRates(rates)
            }
        }

        etFilter.addTextChangedListener { text ->
            val query = text.toString().uppercase()
            val filtered = allRates.filter {
                it.code.contains(query)
            }
            displayRates(filtered)
        }
    }

    private fun displayRates(rates: List<CurrencyRate>) {
        val formatted = rates.map {
            "${it.code} – ${"%.3f".format(it.rate)}"
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            formatted
        )

        listView.adapter = adapter
    }
}
