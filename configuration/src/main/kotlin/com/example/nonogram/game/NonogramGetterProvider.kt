package com.example.nonogram.game

import BoardDefinitionConverter
import FileNonogramGetter
import com.example.nonogram.configuration.ConfigurationProperties
import port.persistence.NonogramGetter

class NonogramGetterProvider(
    private val configurationProperties: ConfigurationProperties,
    private val boardDefinitionConverter: BoardDefinitionConverter,
) {

    fun provide(): NonogramGetter {
        return FileNonogramGetter(configurationProperties.getGameDefinitionFile(), boardDefinitionConverter)
    }
}