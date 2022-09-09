package com.example.nonogram

import NonogramProviderImpl
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NonogramApplication : CommandLineRunner {

    override fun run(vararg args: String?) {
        NonogramProviderImpl().doNothing()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<NonogramApplication>(*args)
        }
    }
}
