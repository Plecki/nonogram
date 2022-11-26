package com.example.nonogram

import BoardDefinitionConverter
import FileNonogramGetter
import InMemoryPersistence
import LineDefinitionConverter
import RowColSplitter
import com.example.nonogram.configuration.ConfigurationProperties
import com.example.nonogram.desktop.DesktopGame
import com.example.nonogram.desktop.DesktopPresentation
import com.example.nonogram.game.GameProvider
import com.example.nonogram.terminal.TerminalGame
import com.example.nonogram.terminal.TerminalInputProvider
import com.example.nonogram.terminal.TerminalPresentation
import domain.model.state.ArrayBoardStateFactory
import domain.model.state.BoardStateFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import port.persistence.NonogramGetter
import port.persistence.NonogramPersistence
import usecase.*

class NonogramApplication : KoinComponent {
    private val nonogramPresentationUseCase by inject<NonogramPresentationUseCase>()

    companion object {
        private val nonogramModule = module {
            singleOf(::BoardDefinitionConverter)
            singleOf(::RowColSplitter)
            singleOf(::LineDefinitionConverter)
            singleOf(::DesktopPresentation)
            singleOf(::TerminalPresentation)
            singleOf(::TerminalInputProvider)
            singleOf(::ConfigurationProperties)
            singleOf(::TerminalGame)
            singleOf(::DesktopGame)
            factory { GameProvider(get(), get(), get()).provide() }
            single { FileNonogramGetter("simple-nonogram.txt", get()) as NonogramGetter }
            single { ArrayBoardStateFactory() as BoardStateFactory }
            single { NonogramPresentationUseCaseImpl(get(), get(), get(), get()) as NonogramPresentationUseCase }
            single { GetBoardUseCaseImpl(get()) as GetBoardUseCase }
            single { GetBoardStateUseCaseImpl() as GetBoardStateUseCase }
            single { UpdateCellStateUseCaseImpl(get()) as UpdateCellStateUseCase }
            single { InMemoryPersistence() as NonogramPersistence }
        }

        @JvmStatic
        fun main(args: Array<String>) {

            startKoin {
                printLogger()
                modules(nonogramModule)
            }

            NonogramApplication().showNonogram()
        }
    }

    private fun showNonogram() {
        nonogramPresentationUseCase.showNonogram()
    }
}