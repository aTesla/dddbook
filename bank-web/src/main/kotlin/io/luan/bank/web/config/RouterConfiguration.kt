package io.luan.bank.web.config

import io.luan.bank.web.handler.RegistrationHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter
import org.springframework.web.reactive.function.server.router

/**
 * https://ruanyifeng.com/blog/2014/05/restful_api.html
 */
@Configuration(proxyBeanMethods = false)
class RouterConfiguration {
    @Bean
    fun mainRouter(handler: RegistrationHandler) = coRouter {
//        GET("/users/register", accept(APPLICATION_JSON), handler::listPeople)
        GET("/users/register", handler::register)
//        "/api/v1/admins".nest {
//            accept(MediaType.APPLICATION_JSON).nest {
//                POST("", handler::create)
//                GET("/{id}", handler::read)
//                PUT("/{id}", handler::update)
//                DELETE("/{id}", handler::delete)
//                GET("", handler::readAll)
//                PATCH("/{id}", handler::updateHidden)
//            }
//        }
    }
}