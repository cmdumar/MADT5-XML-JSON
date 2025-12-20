package com.example.madt_5

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayInputStream

class ParserTest {

    @Test
    fun parse_validXml_returnsCurrencyRates() {
        val xml = """
            <channel>
                <item>
                    <targetCurrency>EUR</targetCurrency>
                    <exchangeRate>0.925</exchangeRate>
                </item>
                <item>
                    <targetCurrency>GBP</targetCurrency>
                    <exchangeRate>0.785</exchangeRate>
                </item>
            </channel>
        """.trimIndent()

        val inputStream = ByteArrayInputStream(xml.toByteArray())
        val parser = Parser()

        val result = parser.parse(inputStream)

        assertEquals(2, result.size)
        assertEquals("EUR", result[0].code)
        assertEquals(0.925, result[0].rate, 0.001)
    }
}
