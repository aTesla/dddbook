package io.luan.bank.domain.types

import io.luan.bank.types.AccountNumber
import io.luan.bank.types.Money
import io.luan.bank.types.UserId
import java.math.BigDecimal
import java.util.*

data class AuditMessage(
    val userId: UserId,
    val source: AccountNumber,
    val target: AccountNumber,
    val money: Money,
    val date: Date,
) {
    fun serialize(): String {
        return "$userId,$source,$target,$money,$date"
    }

    companion object {
        fun deserialize(value: String): AuditMessage {
            return AuditMessage(
                userId = UserId(-1L),
                source = AccountNumber(""),
                target = AccountNumber(""),
                money = Money(BigDecimal.ONE, Currency.getInstance("CN")),
                date = Date(),
            )
        }
    }
}