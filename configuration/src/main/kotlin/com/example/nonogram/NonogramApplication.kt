package com.example.nonogram

import NonogramPresentationUseCase
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NonogramApplication(
    private val nonogramPresentationUseCase: NonogramPresentationUseCase,
) : CommandLineRunner {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<NonogramApplication>(*args)
        }
    }

    override fun run(vararg args: String?) {
        showNonogram()
    }

    private fun showNonogram() {
        nonogramPresentationUseCase.showNonogram()
    }
}