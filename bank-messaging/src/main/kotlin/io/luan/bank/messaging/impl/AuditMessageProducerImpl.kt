package io.luan.bank.messaging.impl

import io.luan.bank.domain.types.AuditMessage
import io.luan.bank.domain.types.SendResult
import io.luan.bank.messaging.AuditMessageProducer
import org.springframework.kafka.core.KafkaTemplate

class AuditMessageProducerImpl(private val kafkaTemplate: KafkaTemplate<String, String>) : AuditMessageProducer {
    override fun send(message: AuditMessage): SendResult {
        val messageBody = message.serialize()
        kafkaTemplate.send(TOPIC_AUDIT_LOG, messageBody)
        return SendResult.success()
    }

    companion object {
        private const val TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG"
    }
}