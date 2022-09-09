package com.example.nonogram

import NonogramPresentation
import NonogramProvider
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

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