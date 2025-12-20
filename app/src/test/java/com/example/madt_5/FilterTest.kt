package com.example.madt_5

import org.junit.Assert.assertEquals
import org.junit.Test

class FilterTest {

    @Test
    fun filterCurrencies_returnsMatchingCurrency() {
        val rates = listOf(
            CurrencyRate("EUR", 0.9),
            CurrencyRate("USD", 1.0),
            CurrencyRate("GBP", 0.8)
        )

        val query = "eu"
        val filtered = rates.filter {
            it.code.contains(query.uppercase())
        }

        assertEquals(1, filtered.size)
        assertEquals("EUR", filtered[0].code)
    }
}
