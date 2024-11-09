package io.luan.bank.configuration

import io.luan.bank.application.RegistrationService
import io.luan.bank.application.TransferService
import io.luan.bank.application.impl.RegistrationServiceImpl
import io.luan.bank.application.impl.TransferServiceImplNew
import io.luan.bank.domain.service.AccountTransferService
import io.luan.bank.domain.service.impl.AccountTransferServiceImpl
import io.luan.bank.external.ExchangeRateService
import io.luan.bank.external.impl.ExchangeRateServiceImpl
import io.luan.bank.messaging.AuditMessageProducer
import io.luan.bank.messaging.impl.AuditMessageProducerImpl
import io.luan.bank.repository.AccountRepository
import io.luan.bank.repository.impl.AccountRepositoryImpl
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate

@Configuration(proxyBeanMethods = false)
class BankConfiguration {
    @Bean
    fun createTransferService(
        accountRepository: AccountRepository,
        auditMessageProducer: AuditMessageProducer,
        exchangeRateService: ExchangeRateService,
        accountTransferService: AccountTransferService,
    ): TransferService {
        return TransferServiceImplNew(
            accountRepository,
            auditMessageProducer,
            exchangeRateService,
            accountTransferService,
        )
    }

//    @Bean
//    fun createAccountRepository(accountMapper: AccountMapper): AccountRepository {
//        return AccountRepositoryImpl(accountMapper)
//    }

    @Bean
    fun createAccountRepository(): AccountRepository {
        return AccountRepositoryImpl()
    }

    @Bean
    fun createAuditMessageProducer(kafkaTemplate: KafkaTemplate<String, String>): AuditMessageProducer {
        return AuditMessageProducerImpl(kafkaTemplate)
    }

    @Bean
    fun createExchangeRateService(): ExchangeRateService {
        return ExchangeRateServiceImpl(ExchangeRateServiceImpl.YahooForexService())
    }

    @Bean
    fun createAccountTransferService(): AccountTransferService {
        return AccountTransferServiceImpl()
    }

    @Bean
    fun createKafkaTemplate(): KafkaTemplate<String, String> {
        val configs = mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        )
        val producerFactory = DefaultKafkaProducerFactory<String, String>(configs)
        return KafkaTemplate(producerFactory)
    }

    @Bean
    fun createRegistrationService(): RegistrationService {
        return RegistrationServiceImpl()
    }
}