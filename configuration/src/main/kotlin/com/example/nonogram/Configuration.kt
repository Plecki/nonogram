package com.example.nonogram

import NonogramPresentation
import NonogramProvider
import NonogramProviderImpl
import TerminalPresentation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun nonogramProvider(): NonogramProvider {
        return NonogramProviderImpl()
    }

    @Bean
    fun nonogramPresentation(): NonogramPresentation {
        return TerminalPresentation()
    }
}