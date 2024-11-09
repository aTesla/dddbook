package io.luan.bank.domain.service

import io.luan.bank.domain.entity.Account
import io.luan.bank.types.ExchangeRate
import io.luan.bank.types.Money

interface AccountTransferService {
    fun transfer(
        sourceAccount: Account,
        targetAccount: Account,
        targetMoney: Money,
        exchangeRate: ExchangeRate,
    )
}