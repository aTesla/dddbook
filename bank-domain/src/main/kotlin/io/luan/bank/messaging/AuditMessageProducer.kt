package io.luan.bank.messaging

import io.luan.bank.domain.types.AuditMessage
import io.luan.bank.domain.types.SendResult

interface AuditMessageProducer {
    fun send(message: AuditMessage): SendResult
}