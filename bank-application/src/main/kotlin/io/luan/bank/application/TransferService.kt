package io.luan.bank.application

import java.math.BigDecimal

interface TransferService {
    fun transfer(
        sourceUserId: Long,
        targetAccountNumber: String,
        targetAmount: BigDecimal,
        targetCurrency: String,
    ): Boolean
}