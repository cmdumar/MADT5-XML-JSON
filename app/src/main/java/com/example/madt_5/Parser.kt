package com.example.madt_5

import org.w3c.dom.Element
import java.io.InputStream
import javax.xml.parsers.DocumentBuilderFactory

class Parser {

    fun parse(inputStream: InputStream): List<CurrencyRate> {
        val rates = mutableListOf<CurrencyRate>()

        val document = DocumentBuilderFactory
            .newInstance()
            .newDocumentBuilder()
            .parse(inputStream)

        val nodes = document.getElementsByTagName("item")

        for (i in 0 until nodes.length) {
            val element = nodes.item(i) as Element

            val code = element
                .getElementsByTagName("targetCurrency")
                .item(0)
                .textContent

            val rate = element
                .getElementsByTagName("exchangeRate")
                .item(0)
                .textContent
                .toDouble()

            rates.add(CurrencyRate(code, rate))
        }

        return rates
    }
}
