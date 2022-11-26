package com.example.nonogram.configuration

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec

class ConfigurationPropertiesIT : ShouldSpec({

    should("get game mode from properties") {
        shouldNotThrowAny { ConfigurationProperties().getGameMode() }
    }

    should("get game definition file from properties") {
        shouldNotThrowAny { ConfigurationProperties().getGameDefinitionFile() }
    }
})
