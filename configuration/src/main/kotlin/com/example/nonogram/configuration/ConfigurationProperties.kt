package com.example.nonogram.configuration

import com.example.nonogram.game.GameMode
import java.io.File
import java.io.FileInputStream
import java.util.*

class ConfigurationProperties {
    private val FILE_NAME = "configuration.properties"

    private val properties: Properties = Properties()

    init {
        properties.load(FileInputStream(File(this::class.java.classLoader.getResource(FILE_NAME).toURI())))
    }

    fun getGameMode(): GameMode {
        return GameMode.fromProperty(properties.getProperty("game.mode"))
    }
}