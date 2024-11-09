package io.luan.bank.types

import java.math.BigDecimal
import java.util.Currency

data class ExchangeRate(val rate: BigDecimal, val from: Currency, val to: Currency) {

    fun exchangeTo(fromMoney: Money): Money {
        //check(from == fromMoney.currency)
        require(from == fromMoney.currency)
        //assert(from == fromMoney.currency)
        val targetAmount = fromMoney.amount.multiply(rate)
        return Money(targetAmount, to)
    }
}
