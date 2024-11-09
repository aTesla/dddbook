package io.luan.bank.web.handler

import io.luan.bank.application.RegistrationService
import io.luan.bank.types.Address
import io.luan.bank.types.Name
import io.luan.bank.types.PhoneNumber
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json
import org.springframework.web.reactive.function.server.queryParamOrNull
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.random.Random

@Component
class RegistrationHandler(private val registrationService: RegistrationService) {

    private val personList = listOf(
        Pair(1L, "曹操"),
        Pair(2L, "刘备"),
        Pair(3L, "孙权"),
    )

    suspend fun listPeople(request: ServerRequest): ServerResponse {
//        val people = Flux.fromIterable(personList)
        return ServerResponse.ok().json().bodyValueAndAwait(personList)
    }

    suspend fun register(request: ServerRequest): ServerResponse {
        val name = request.queryParamOrNull("name")
        val phone = request.queryParamOrNull("number")
        val address = request.queryParamOrNull("address")
        requireNotNull(name)
        requireNotNull(phone)
        requireNotNull(address)
        val result = runCatching {
            registrationService.register(Name(name), PhoneNumber(phone), Address(address))
        }

        if (result.isFailure) {
            print(result)
            return ServerResponse.notFound().buildAndAwait()
        }

        return ServerResponse.ok().json().bodyValueAndAwait(Triple(Random.nextLong(), "a", false))
    }

}