package com.example.nonogram

import BoardDefinitionConverter
import FileNonogramGetter
import InMemoryPersistence
import LineDefinitionConverter
import RowColSplitter
import com.example.nonogram.desktop.DesktopPresentation
import domain.state.ArrayBoardStateFactory
import domain.state.BoardStateFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import port.persistence.NonogramGetter
import port.persistence.NonogramPersistence
import port.presentation.NonogramPresentation
import usecase.*

class NonogramApplication : KoinComponent {
    private val nonogramPresentationUseCase by inject<NonogramPresentationUseCase>()

    companion object {
        private val nonogramModule = module {
            singleOf(::BoardDefinitionConverter)
            singleOf(::RowColSplitter)
            singleOf(::LineDefinitionConverter)
            single { DesktopPresentation() as NonogramPresentation }
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