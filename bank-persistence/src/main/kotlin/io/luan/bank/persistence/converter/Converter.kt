package io.luan.bank.persistence.converter

import io.luan.bank.domain.entity.Account
import io.luan.bank.persistence.AccountDO
import io.luan.bank.types.AccountId
import io.luan.bank.types.AccountNumber
import io.luan.bank.types.Money
import io.luan.bank.types.UserId
import java.math.BigDecimal
import java.util.Currency

fun AccountDO.toAccount(): Account {
    return Account(
        id = AccountId(-1L),
        accountNumber = AccountNumber(""),
        userId = UserId(-1L),
        available = Money(BigDecimal.ONE, Currency.getInstance("CN")),
        dailyLimit = Money(BigDecimal.ONE, Currency.getInstance("CN")),
    )
}

fun Account.toAccountDO(): AccountDO {
    return AccountDO(
    )
}