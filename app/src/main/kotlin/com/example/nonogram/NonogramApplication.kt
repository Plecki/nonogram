package com.example.nonogram

import NonogramPresentation
import NonogramProvider
import NonogramProviderImpl
import TerminalPresentation
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class NonogramApplication(
    private val nonogramProvider: NonogramProvider,
    private val nonogramPresentation: NonogramPresentation,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        nonogramProvider.doNothing()
        nonogramPresentation.present()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<NonogramApplication>(*args)
        }
    }
}

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