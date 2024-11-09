package io.luan.bank.types

import java.math.BigDecimal
import java.util.Currency

data class Money(val amount: BigDecimal, val currency: Currency) : Comparable<Money> {
    init {
        require(amount.compareTo(BigDecimal.ZERO) == 1)
    }

    fun add(other: Money): Money {
        return this + other
    }

    fun subtract(other: Money): Money {
        return this - other
    }

    operator fun plus(other: Money): Money {
        assert(this.currency == other.currency)
        return Money(this.amount + other.amount, this.currency)
    }

    operator fun minus(other: Money): Money {
        assert(this.currency == other.currency)
        return Money(this.amount - other.amount, this.currency)
    }

    override fun compareTo(other: Money): Int {
        return this.amount.compareTo(other.amount)
    }
}
