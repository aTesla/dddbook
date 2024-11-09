package io.luan.bank.external

import io.luan.bank.types.ExchangeRate
import java.util.*


interface ExchangeRateService {
    fun getExchangeRate(source: Currency, target: Currency): ExchangeRate
}