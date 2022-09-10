package com.example.nonogram

import FileNonogramGetter
import NonogramPresentationUseCase
import NonogramPresentationUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import port.persistence.NonogramGetter
import port.presentation.NonogramPresentation

@Configuration
class Configuration {

    @Bean
    fun nonogramProvider(
        nonogramPresentation: NonogramPresentation,
        nonogramGetter: NonogramGetter,
    ): NonogramPresentationUseCase {
        return NonogramPresentationUseCaseImpl(nonogramPresentation, nonogramGetter)
    }

    @Bean
    fun nonogramPresentation(): NonogramPresentation {
        return TerminalPresentation()
    }

    @Bean
    fun nonogramGetter(): NonogramGetter {
        return FileNonogramGetter()
    }
}