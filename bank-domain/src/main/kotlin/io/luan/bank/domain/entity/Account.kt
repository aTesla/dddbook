package io.luan.bank.domain.entity

import io.luan.bank.types.AccountId
import io.luan.bank.types.AccountNumber
import io.luan.bank.types.Money
import io.luan.bank.types.UserId

data class Account(
    val id: AccountId,
    val accountNumber: AccountNumber,
    val userId: UserId,
    private var available: Money,
    val dailyLimit: Money,
) {
    val currency get() = this.available.currency

    // 转入
    fun deposit(money: Money) {
        require(this.currency == money.currency)
        this.available = this.available.add(money)
    }

    // 转出
    fun withdraw(money: Money) {
        require(this.currency == money.currency)
        require(this.available >= money)
        require(this.dailyLimit >= money)
        this.available = this.available.subtract(money)
    }
}
