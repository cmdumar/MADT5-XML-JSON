package com.example.madt_5

import java.net.URL
import kotlin.concurrent.thread

class DataLoader {

    fun loadData(onResult: (List<CurrencyRate>) -> Unit) {
        thread {
            try {
                val url = URL("http://www.floatrates.com/daily/usd.xml")
                val connection = url.openConnection()
                val inputStream = connection.getInputStream()

                val parser = Parser()
                val result = parser.parse(inputStream)

                onResult(result)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult(emptyList())
            }
        }
    }
}
