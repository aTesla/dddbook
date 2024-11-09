package io.luan.bank.web.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@Configuration(proxyBeanMethods = false)
class WebConfig
// org.springframework.web.reactive.config.WebFluxConfigurer
//class WebConfig : WebFluxConfigurer {
//    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
//        super.configureHttpMessageCodecs(configurer)
//    }
//
//    override fun addCorsMappings(registry: CorsRegistry) {
//        super.addCorsMappings(registry)
//    }
//
//    override fun configureViewResolvers(registry: ViewResolverRegistry) {
//        super.configureViewResolvers(registry)
//    }
//}