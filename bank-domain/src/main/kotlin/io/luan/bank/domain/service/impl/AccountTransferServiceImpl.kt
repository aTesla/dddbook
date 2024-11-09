package io.luan.bank.domain.service.impl

import io.luan.bank.domain.entity.Account
import io.luan.bank.domain.service.AccountTransferService
import io.luan.bank.types.ExchangeRate
import io.luan.bank.types.Money

class AccountTransferServiceImpl : AccountTransferService {
    override fun transfer(
        sourceAccount: Account,
        targetAccount: Account,
        targetMoney: Money,
        exchangeRate: ExchangeRate,
    ) {
        val sourceMoney = exchangeRate.exchangeTo(targetMoney)
        sourceAccount.deposit(sourceMoney)
        targetAccount.withdraw(targetMoney)
    }
}