package com.example.nonogram

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NonogramApplication

fun main(args: Array<String>) {
    runApplication<NonogramApplication>(*args)
}
