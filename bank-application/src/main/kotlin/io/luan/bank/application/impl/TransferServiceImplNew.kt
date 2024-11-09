package io.luan.bank.application.impl

import io.luan.bank.application.TransferService
import io.luan.bank.domain.service.AccountTransferService
import io.luan.bank.domain.types.AuditMessage
import io.luan.bank.external.ExchangeRateService
import io.luan.bank.messaging.AuditMessageProducer
import io.luan.bank.repository.AccountRepository
import io.luan.bank.types.AccountNumber
import io.luan.bank.types.Money
import io.luan.bank.types.UserId
import java.math.BigDecimal
import java.util.*

class TransferServiceImplNew(
    private val accountRepository: AccountRepository,
    private val auditMessageProducer: AuditMessageProducer,
    private val exchangeRateService: ExchangeRateService,
    private val accountTransferService: AccountTransferService,
) : TransferService {
    override fun transfer(
        sourceUserId: Long,
        targetAccountNumber: String,
        targetAmount: BigDecimal,
        targetCurrency: String
    ): Boolean {
        // 参数校验
        val targetMoney = Money(targetAmount, Currency.getInstance(targetCurrency))

        // 读数据
        val sourceAccount = accountRepository.find(UserId(sourceUserId))
        val targetAccount = accountRepository.find(AccountNumber(targetAccountNumber))
        checkNotNull(sourceAccount)
        checkNotNull(targetAccount)
        val exchangeRate = exchangeRateService.getExchangeRate(sourceAccount.currency, targetMoney.currency)

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate)

        // 保存数据
        accountRepository.save(sourceAccount)
        accountRepository.save(targetAccount)

        // 发送审计消息
        val message = AuditMessage(
            UserId(sourceUserId),
            sourceAccount.accountNumber,
            targetAccount.accountNumber,
            targetMoney,
            Date(),
        )
        auditMessageProducer.send(message)

        return true
    }

}