package io.luan.bank.external.impl

import io.luan.bank.external.ExchangeRateService
import io.luan.bank.types.ExchangeRate
import java.math.BigDecimal
import java.util.*

class ExchangeRateServiceImpl(private val yahooForexService: YahooForexService) : ExchangeRateService {
    override fun getExchangeRate(source: Currency, target: Currency): ExchangeRate {
        if (source == target) {
            return ExchangeRate(BigDecimal.ONE, source, target)
        }
        val forex = yahooForexService.getExchangeRate(source, target)
        return ExchangeRate(forex, source, target)
    }

    // mock
    class YahooForexService {
        fun getExchangeRate(source: Currency, target: Currency): BigDecimal {
            return BigDecimal.ONE
        }
    }
}