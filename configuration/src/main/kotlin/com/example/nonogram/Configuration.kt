package com.example.nonogram

import BoardDefinitionConverter
import FileNonogramGetter
import LineDefinitionConverter
import NonogramPresentationUseCase
import NonogramPresentationUseCaseImpl
import RowColSplitter
import com.example.nonogram.terminal.TerminalPresentation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import port.persistence.NonogramGetter
import port.presentation.NonogramPresentation

@Configuration
@ComponentScan
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
    fun nonogramGetter(boardDefinitionConverter: BoardDefinitionConverter): NonogramGetter {
        // TODO configuration of file
        return FileNonogramGetter("simple-nonogram.txt", boardDefinitionConverter)
    }

    @Bean
    fun boardDefinitionConverter(): BoardDefinitionConverter {
        return BoardDefinitionConverter(RowColSplitter(), LineDefinitionConverter())
    }
}